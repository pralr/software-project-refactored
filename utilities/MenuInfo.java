package utilities;

public class MenuInfo implements MenuPattern {
	
	@Override
	public void pattern() {
		System.out.println("---------------------------------- MENU INFO --------------------------------------");
		System.out.println("1 - Profile | 2 - Communities | 3 - Friends | 4 - All Messages | 5 - Return to Menu");
		System.out.println("-----------------------------------------------------------------------------------");
		
	}
}
