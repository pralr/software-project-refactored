package utilities;

public class MenuFeed implements MenuPattern {

	@Override
	public void pattern() {
		System.out.println("---------------------------- MENU INFO --------------------------------");
		System.out.println("1 - Send message to feed | 2 - Show feed's message | 3 - Return to Menu");
		System.out.println("-----------------------------------------------------------------------");
	}
	
}
