import java.net.*;
import java.io.IOException;

public class Server { 

  public static StringBuilder data(byte[] a) 	{ 
		if (a == null) 
			return null;
		StringBuilder ret = new StringBuilder(); 
		int i = 0;
		while (a[i] != 0) { ret.append((char) a[i++]); } 
		return ret; 
	}

	public static void main(String[] args) {
    DatagramSocket ds = null;
		try {
      ds = new DatagramSocket(5000); 
    } catch (SocketException e) {
      System.err.println(e);
    }
		byte[] receive = new byte[65535];
		while (true) { 
			DatagramPacket DpReceive = new DatagramPacket(receive, receive.length); 
			try {
        ds.receive(DpReceive);
      } catch (IOException e) {
        System.err.println(e);
      }
			System.out.println("Client says: " + data(receive));
			if (data(receive).toString().equalsIgnoreCase("bye")) { break; } 
			receive = new byte[65535]; 
		} 
	}
}
