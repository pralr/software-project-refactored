package entities;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import utilities.Feed;

public class FeedArea {
	
	private Account account = new Account(); 
	private List<Feed> Feed = new ArrayList<>();

	public FeedArea(Account account, List<utilities.Feed> feed) {
		this.account = account;
		Feed = feed;
	}
	
	Scanner sc = new Scanner(System.in);

	public void menu() {
		Integer option = 0;
		while(option!=3) {	
			try {
				option = sc.nextInt();
				System.out.println(option);
				switch(option) {
				case 1:
					sendMessageToFeed();
					break;
				case 2:
					showFeedMessage();
					option = 3;
					break;
				default:
					System.out.println("Invalid value");
					break;
				}
			} catch(InputMismatchException e) {
			   	System.out.println("Please, choose a number.");
				sc.nextLine();
			}
			
		}
	}
	
	public void sendMessageToFeed() {
		System.out.println("Do you want to post (1) public or (2) private?");
		Integer option = sc.nextInt();
		if (option.equals(1) || option.equals(2)) {
			System.out.println("Type your message: ");
			sc.nextLine();
			String message = sc.nextLine();
			Feed newMessage = new Feed(account.getLogin(), message, option);
			Feed.add(newMessage); 
		} else {
			System.out.println("Invalid value.");
		}
	}
	
	public void showFeedMessage() {
		if (Feed.isEmpty()) { 
			System.out.println("NO MESSAGES.");
		}

		for (Feed f : Feed) {
			if (f.getPermission() == 1) {
				System.out.println("[PUBLIC] " + f.getSender() + ": " + f.getMessage());
			}
			if (f.getPermission() == 2) {
				if (f.getSender().equals(account.getLogin()) || account.getFriends().contains(f.getSender())) {
					System.out.println("[PRIVATE] " + f.getSender() + ": " + f.getMessage());

				}

			}

		}
	}

}
