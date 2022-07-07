package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Account;
import entities.AccountArea;
import entities.Community;
import entities.CommunityArea;
import entities.FeedArea;
import entities.FriendArea;
import entities.InfoArea;

public class Menu extends MenuFirst {
	
	private Account account, users = new Account();
	private Community communities = new Community();
	
	private List<Feed> Feed = new ArrayList<>();
	private List<Chat> messagesChat = new ArrayList<>();
	private List<CommunityMsg> commMessages = new ArrayList<>();
	
	public Menu(Account account, Account users, Community communities, List<utilities.Feed> feed,
			List<Chat> messagesChat, List<CommunityMsg> commMessages) {
		this.account = account;
		this.users = users;
		this.communities = communities;
		Feed = feed;
		this.messagesChat = messagesChat;
		this.commMessages = commMessages;
	}
	
	Scanner sc = new Scanner(System.in);

	public void welcome() {
		System.out.println("Welcome to Iface, " + account.getNickname() + "!");
		menu(account);
	}
	
	public void menu(Account account) {
		while(true) {
			pattern();
			Integer option = sc.nextInt();
			switch(option) {
			case 1:
				AccountArea accountArea = new AccountArea(account);
				accountArea.menu();
				break;
			case 2: 
				FriendArea friendArea = new FriendArea(account, users, messagesChat);
				friendArea.menu();
				break;
			case 3:
				CommunityArea communityArea = new CommunityArea(account, communities, commMessages);
				communityArea.menu();
				break;
			case 4: 
				InfoArea infoArea = new InfoArea(account);
				infoArea.info();
				break;
			case 5: 
				FeedArea feedArea = new FeedArea(account, Feed);
				feedArea.showFeedMessage();
				break;
			case 6:
				return;
			}
			break;
		}
	}
}
