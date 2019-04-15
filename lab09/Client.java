import java.net.*;
import java.util.Scanner;
import java.io.IOException;

public class Client { 
	public static void main(String args[]) { 
		Scanner sc = new Scanner(System.in);
    DatagramSocket ds = null;
    InetAddress ip = null;
    try {
      ds = new DatagramSocket(); 
      ip = InetAddress.getLocalHost(); 
    } catch (SocketException e) {
      System.err.println(e);
    } catch (UnknownHostException e) {
      System.err.println(e);
    }

		byte buffer[] = null; 
    System.out.println("Send messages below:");
		while (true) { 
			String inp = sc.nextLine();
			buffer = inp.getBytes();
			DatagramPacket DpSend = new DatagramPacket(buffer, buffer.length, ip, 5000); 
			try {
        ds.send(DpSend); 
      } catch (IOException e) {
        System.err.println(e);
      }
			if (inp.equalsIgnoreCase("bye")) { break; }
		}
	}
}
