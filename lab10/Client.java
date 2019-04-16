import java.io.*;
import java.net.*;

public class Client {
  public static void main(String[] args) {
		int serverPort = 6969;
		Socket socket = null;
		ObjectOutputStream toServer = null;
		ObjectInputStream fromServer = null;
		try {
			if(args.length != 1) {
				System.out.println("Need minimum 1 argument");
				System.exit(1);
			}
			int number = Integer.parseInt(args[0]);
			InetAddress serverHost = InetAddress.getByName("localhost"); 
			System.out.println("Connecting to server on port " + serverPort); 
			socket = new Socket(serverHost,serverPort); 
			System.out.println("Just connected to " + socket.getRemoteSocketAddress()); 
			toServer = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			Message msgToSend = new Message(number);
			toServer.writeObject(msgToSend);
			toServer.flush();
			
			fromServer = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			Message msgFromReply = (Message) fromServer.readObject();
			System.out.println(number + " * " + number + " = " + msgFromReply.getNumber());
		}
		catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		finally {
			if(socket != null) {
				try {
					socket.close();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
