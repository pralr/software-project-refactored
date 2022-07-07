package entities;

import java.util.InputMismatchException;
import java.util.Scanner;

import utilities.MenuAccount;

public class AccountArea extends Funcionalities {
	
	private Account account = new Account();
	private MenuAccount menu = new MenuAccount();
	
	Scanner sc = new Scanner(System.in);
	
	public AccountArea() {
		
	}
	
	public AccountArea(Account account) {
		this.account = account;
	}
	
	@Override
	public void update() {
		account.update();
		
	}
	@Override
	public void delete() {
		System.out.println("Your account has been deleted.");
		account.delete();
		
	}

	@Override
	public void create() {
		account.create();
		
	}

	@Override
	public boolean get() {
		account.get();
		return false;
	}
	
	public void menu() {
		Integer option = 0;
		while(option!=3) {	
			try {
				menu.pattern();
				option = sc.nextInt();
				System.out.println(option);
				switch(option) {
				case 1:
					update();
					break;
				case 2:
					delete();
					option = 3;
					break;
				default:
					System.out.println("Invalid value");
					break; 
			} } catch(InputMismatchException e) {
			   	System.out.println("Please, choose a number.");
				sc.nextLine();
			}
			
		}
			
	}
}
