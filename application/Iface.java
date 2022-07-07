package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Account;
import entities.Community;
import utilities.Chat;
import utilities.CommunityMsg;
import utilities.Feed;
import utilities.Menu;
import utilities.SearchAccount;

public class Iface {
	
	private Account users = new Account();
	private Community communities = new Community();
	private List<Feed> feed = new ArrayList<>();
	private List<Chat> messagesChat = new ArrayList<>();
	private List<CommunityMsg> commMessages = new ArrayList<>();
	
	private Account example = new Account("pri", "senha", "apelido");
	
	Scanner sc = new Scanner(System.in);
	
	public Iface() {
		users.getUsers().add(example);
	}
	
	public void on() {
		
		while(true) 
			loginAccount();
	}
	
	public void loginAccount() {
	SearchAccount user = new SearchAccount();
	System.out.print("Insert login: ");
	String login = sc.next();
	
	try {
	if(user.search(users.getUsers(), login)!=null) {
		Account account = user.search(users.getUsers(), login);
		System.out.print("Insert password: ");
		if(account.getPassword().equals(sc.next())) {
			Menu menu = new Menu(account, users, communities, feed, messagesChat, commMessages);
			menu.welcome();
			return;
		}
		System.out.println("Incorrect password.");
	} else {
		notFound();
	} } catch(NullPointerException e) {
		notFound();
	}
}

	public void newAccount() {
		Account account = new Account();
		account.create();
		users.getUsers().add(account);
		Menu menu = new Menu(account, users, communities, feed, messagesChat, commMessages);
		menu.welcome();
	}
	
	public void notFound() {
		String opt;
		System.out.println("User not found. Do you wish create a new account? (y/n)");
		opt = sc.next();
		if(opt.equals("y")) {
			newAccount();
		}
		return;
	}
		
}
