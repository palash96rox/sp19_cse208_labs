import java.net.*; 
import java.io.*; 

public class Client { 

	private Socket socket		 = null; 
	private DataOutputStream out	 = null; 

	public Client(String address, int port) { 
		try { 
			socket = new Socket(address, port); 
			out = new DataOutputStream(socket.getOutputStream()); 
			out.writeBytes("I am connected");
		} catch(UnknownHostException u) { 
			System.out.println(u); 
		} catch(IOException i) { 
			System.out.println(i); 
		}
		// Close connection
		try {
			out.close(); 
			socket.close(); 
		} catch(IOException i) { 
			System.out.println(i); 
		} 
	} 

	// Driver Method
	public static void main(String args[]) {
		Client client = new Client("localhost", 5500); 
	} 
} 
