package entities;

public class InfoArea {
	Account acc = new Account();

	public InfoArea(Account acc) {
		this.acc = acc;
	}
	
	public void info() {
		System.out.println("1 - Profile: ");
		System.out.println(acc.toString());
		System.out.println("2 - Communities: ");
		acc.getCommunities();
		System.out.println("3 - Friends: ");
		acc.getFriends();
		System.out.println("4 - All Messages: ");
		//showAllMessages(acc);
	}
	
}
