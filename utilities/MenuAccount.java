package utilities;

public class MenuAccount implements MenuPattern {

	@Override
	public void pattern() {
		System.out.println("--------------------- ACCOUNT MENU -----------------------");
		System.out.println("1 - Edit Account | 2 - Delete Account | 3 - Return to Menu");
		System.out.println("----------------------------------------------------------");
		System.out.println("                     Insert option:                      ");
	}
}