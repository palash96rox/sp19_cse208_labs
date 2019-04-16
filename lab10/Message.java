import java.io.*;

public final class Message implements Serializable {
	private int number;
	Message(int number) {
		this.number = number;
	}
	public int getNumber() { return this.number; }
}