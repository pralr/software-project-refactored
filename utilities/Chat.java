package utilities;

public class Chat extends Message {
	String receiver;

	public Chat(String sender, String message, String receiver) {
		super(sender, message);
		this.receiver = receiver;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
}