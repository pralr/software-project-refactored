package entities;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import utilities.CommunityMsg;
import utilities.MenuCommunity;

public class CommunityArea extends Funcionalities {
	
	private List<CommunityMsg> commMessages = new ArrayList<>();
	private Community cmm, communities = new Community();
	private MenuCommunity menu = new MenuCommunity();
	Account account = new Account();
	
	public CommunityArea() {
		
	}
	
	public CommunityArea(Account account, Community communities, List<CommunityMsg> commMessages) {
		this.account = account;
		this.commMessages = commMessages;
		this.communities = communities;
	}
	
	Scanner sc = new Scanner(System.in);

	@Override
	public void create() {
		cmm.create();
	}

	@Override
	public void update() {
		cmm.update();
	}

	@Override
	public boolean get() {
		cmm.get();
		return false;
	}

	@Override
	public void delete() {
		cmm.delete();
	}

	public List<CommunityMsg> getCommMessages() {
		return commMessages;
	}

	public void setCommMessages(List<CommunityMsg> commMessages) {
		this.commMessages = commMessages;
	}

	public Community getCmm() {
		return cmm;
	}

	public void setCmm(Community cmm) {
		this.cmm = cmm;
	}

	public Community getCommunities() {
		return communities;
	}

	public void setCommunities(Community communities) {
		this.communities = communities;
	}
	
	public void menu() {
		Integer option = 0;
		while(option!=5) {	
			try {
				menu.pattern();
				option = sc.nextInt();
				System.out.println(option);
				switch(option) {
				case 1:
					create();
					break;
				case 2:
					update();
					break;
				case 3:
					cmm.addCmm();
				case 4:
					cmm.sendMsgToCommunity();
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
