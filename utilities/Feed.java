package utilities;

public class Feed extends Message {
	int permission;
	
	public Feed() {
		
	}
	
	public Feed(String sender, String message, int permission) {
		super(sender, message);
		this.permission = permission;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}
	
}