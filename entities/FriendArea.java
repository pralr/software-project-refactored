package entities;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import utilities.Chat;
import utilities.MenuFriend;
import utilities.SearchAccount;

public class FriendArea {
	
	private Account myAccount, friend, users = new Account();
	private List<Chat> messagesChat = new ArrayList<>();
	private MenuFriend menu = new MenuFriend();
	private SearchAccount user = new SearchAccount();
	
	public FriendArea(Account myAccount, Account users, List<Chat> messagesChat) {
		this.myAccount = myAccount;
		this.users = users;
		this.messagesChat = messagesChat;
	}
	
	Scanner sc = new Scanner(System.in);
	
	public void menu() {
		Integer option = 0;
		while(option!=3) {	
			try {
				menu.pattern();
				option = sc.nextInt();
				System.out.println(option);
				switch(option) {
				case 1:
					addFriend();
					break;
				case 2:
					accFriend();
					break;
				case 3:
					sendMessage();
				case 4:
					chat();
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
	

	public void addFriend() {
		System.out.println("Search for: ");
		friend = user.search(users.getUsers(), sc.nextLine());

		if (friend == null) {
			System.out.println("Doesn't exist.");
			return;
		}
		
		if (myAccount.getFriends().contains(friend.getLogin())) {
			System.out.println("You're already friends with " + friend.getLogin() + ".");
			return;
		}

		if (myAccount.getSendInvitation().contains(friend.getLogin())) {
			System.out.println("You're already sent invitation to " + friend.getLogin() + ".");
			return;
		}

		if (myAccount.getReceivedInvitation().contains(friend.getLogin())) {
			System.out.println("The user " + friend.getLogin() + " already sent invitation to you.");
			return;
		}

		if (friend.getLogin().equals(myAccount.getLogin())) {
			System.out.println("You can't add yourself.");
			return;
		}

		friend.getReceivedInvitation().add(myAccount.getLogin());
		myAccount.getSendInvitation().add(friend.getLogin());

		System.out.println("Invite sent.");
	}
	
	public void accFriend() {
		System.out.println(myAccount.getReceivedInvitation());
		System.out.println("Insert user who you want to manage: ");
		friend = user.search(users.getUsers(), sc.nextLine());

		if (myAccount.getReceivedInvitation().contains(friend.getLogin())) {
			System.out.println("Do you want to accept " + friend.getLogin() + "?");
			System.out.println("1 - Yes");
			System.out.println("2 - No");
		    Integer option = sc.nextInt();

			if (option == 1) {
				myAccount.getFriends().add(friend.getLogin());
				friend.getFriends().add(myAccount.getLogin());
				System.out.println("You're friends with " + friend.getLogin() + "!");
			} else if (option == 2) {
				System.out.println("You declined + " + friend.getLogin() + "'s invitation.");
			}
			myAccount.getReceivedInvitation().remove(friend.getLogin());
			friend.getSendInvitation().remove(myAccount.getLogin());
		} else {
			System.out.println("No user with that name has added you.");
			return;
		}
	}
	
	public void sendMessage() {
		System.out.println("Send message to: ");
		String receiver = sc.next();
		if (receiver.equals(myAccount.getLogin())) {
			System.out.println("You can't send messages to yourself.");
			return;
		}
		if (user.search(users.getUsers(), receiver) != null) {
			System.out.println("Type your message: ");
			sc.nextLine();
			String msg = sc.nextLine();
			Chat message = new Chat(myAccount.getLogin(), msg, receiver);
			messagesChat.add(message);
			System.out.println("Message sent successfully.");
		} else {
			System.out.println("Not found.");
		}
	}
	
	
	public void chat() {
		System.out.println("Who do you want to see the messages: ");
		String receiver = sc.next();
		if (user.search(users.getUsers(), receiver) != null) {
			for (Chat msg : messagesChat) {
				if (msg.getSender().equals(receiver) || msg.getSender().equals(myAccount.getLogin())) {
					if (msg.getReceiver().equals(myAccount.getLogin()) || msg.getReceiver().equals(receiver)) {
						System.out.println(msg.getSender() + ": " + msg.getMessage());
					}
				}
			}

		} else {
			System.out.println("Not found.");
		}
	}
	
}
