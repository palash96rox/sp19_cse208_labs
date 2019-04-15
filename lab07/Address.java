import java.net.*;
import java.util.*;

public class Address {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter host name: ");
    String host = sc.next();
    try {
      InetAddress addr = InetAddress.getByName(host);
      System.out.println("IP Address: " + addr.getHostAddress());
      System.out.println("Name and IP: " + addr.toString());
    } catch (UnknownHostException e) {
      System.err.println(e);
    }
    System.out.println();
    System.out.print("Enter IP Address: ");
    String ip = sc.next();
    try {
      InetAddress addr = InetAddress.getByName(ip);
      System.out.println("Hostname: " + addr.getHostName());
      System.out.println("Name and IP: " + addr.toString());
    } catch (UnknownHostException e) {
      System.err.println(e);
    }
    System.out.println();
    sc.close();
  }
}