package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import utilities.CommunityMsg;
import utilities.SearchAccount;
import utilities.SearchCommunity;

public class Community extends Funcionalities {
	private String creator;
	private List<String> members = new ArrayList<>();
	private List<Community> communities = new ArrayList<>();
	private Account user = new Account();
	private List<Account> users = new ArrayList<>();
	private SearchCommunity searchCommunity = new SearchCommunity();
	private SearchAccount searchAccount = new SearchAccount();
	private List<CommunityMsg> commMessages = new ArrayList<>();
	
	
	Scanner sc = new Scanner(System.in);
	
	public Community() {
		
	}
	
	public Community(String name, String description, String creator, List<String> members, Account host, List<Account> users) {
		super.name = name;
		super.description = description;
		this.user = host;
		this.members = new ArrayList<>();
		this.users = new ArrayList<>();
		this.commMessages = new ArrayList<>();
	}
	
	public String getName() {
		return super.name;
	}
	public void setName(String name) {
		super.name = name;
	}
	public String getDescription() {
		return super.description;
	}
	public void setDescription(String description) {
		super.description = description;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public List<String> getMembers() {
		return members;
	}
	public void setMembers(List<String> members) {
		this.members = members;
	}
	
	public List<Community> getCommunities() {
		return communities;
	}

	@Override
	public String toString() {
		return "------ Community created ------" + " \n"
				+ "Name: " + name + " \n"
				+ "Description: " + description + " \n"
				+ "Creator: " + creator;
	}
	
	@Override
	public void create() {
		System.out.print("Community name: ");
		sc.nextLine();
		String communityName = sc.nextLine();
		if (searchCommunity.search(communities, communityName)!=null) {
			System.out.println("Community already exists. Please, choose another name.");
		} else {
			this.setName(name);
			System.out.println("Description: ");
			this.setDescription(sc.nextLine());
			this.setCreator(this.creator);
			communities.add(this); 
			user.getCommunities().add(this); 
		}
		
	}
	
	// manage members 
	@Override
	public void update() {
		sc.nextLine();
		System.out.println("Search community: ");
		String nameCommunity = sc.nextLine();
		Integer option = 0;
		if (searchCommunity.search(communities, nameCommunity) != null) {
			if (searchCommunity.search(communities, nameCommunity).getCreator().equals(user.getLogin())) {
				System.out.println("Search member you want to manage: ");
				String nameMember = sc.nextLine();
				if (searchCommunity.search(communities, nameCommunity).getMembers().contains(nameMember)) {
					System.out.println("Do you want to delete? 1 - Yes / 2 - No");
					option = sc.nextInt();
					switch (option) {
					case 1:
						searchCommunity.search(communities, nameCommunity).getMembers().remove(nameMember);
						Account aux = searchAccount.search(users, nameMember);
						aux.getCommunities().remove(searchCommunity.search(communities, nameCommunity));
						System.out.println("The user " + nameMember + " is not part of this community anymore.");
						searchCommunity.search(communities, nameCommunity).toString();
						return;
					case 2:
						System.out.println("Returning to menu.");
						return;
					default:
						System.out.println("Invalid value.");
						break;
					}

				} else {
					System.out.println("The user doesn't exist in this community. Do you want add? 1 - Yes / 2 - No");
					option = sc.nextInt();
					switch (option) {
					case 1:
						if (searchCommunity.search(communities, nameCommunity) != null) {
							searchCommunity.search(communities, nameCommunity).getMembers().add(nameMember);
							Account aux = searchAccount.search(users, nameMember);
							aux.getCommunities().add(searchCommunity.search(communities, nameCommunity));
							System.out.println("The user " + nameMember + " it's in your community.");
							searchCommunity.search(communities, nameCommunity).toString();

						} else {
							System.out.println("User doesn't exists.");
						}
						return;
					case 2:
						System.out.println("Returning to menu.");
						return;
					default:
						System.out.println("Invalid value.");
						break;
					}

				}

			} else {
				System.out.println("You're not the host of this community.");
				return;
			}
		}

		System.out.println("This community doesn't exists.");
	} 


	@Override
	public boolean get() {
		if(this.name!=null) {
			return true;
		}
		return false;
	}

	@Override
	public void delete() {
		super.name = null;
		super.description = null;
		this.creator = null;
		this.members = null; 
	}
	
	public void addCmm() {
		System.out.println("Search community: ");
		sc.nextLine();
		String comm = sc.nextLine();
		if (searchCommunity.search(communities, comm) != null) {
			Community aux = searchCommunity.search(communities, comm);
			for (Community c : user.getCommunities()) {
				if (c.getName().equals(comm)) {
					System.out.println("You're already in this community.");
					return;
				}
			}
			user.getCommunities().add(searchCommunity.search(communities, comm));
			System.out.println("You're now member of: " + comm);
			aux.getMembers().add(user.getLogin());
			return;
		}
		System.out.println("Community doesn't exist.");
	}
	
	public void sendMsgToCommunity() {
		System.out.println("------------MY COMMUNITIES--------------");
		for (Community c : user.getCommunities()) {
			System.out.println("-----> " + c.getName());
			System.out.println("------------------------------------");
		}
		System.out.println("Community you want to send a message: ");
		sc.nextLine();
		String comm = sc.nextLine();
		if (searchCommunity.search(communities, comm) != null) {
			if (user.getCommunities().contains(searchCommunity.search(communities, comm))) {
				System.out.println("Send message to: " + comm);
				String msg = sc.nextLine();
				CommunityMsg newmsg = new CommunityMsg(user.getLogin(), msg, comm);
				commMessages.add(newmsg);
				System.out.println("Do you want to see community messages? 1 - Yes / 2 - No");
				Integer opt = sc.nextInt();
				if (opt.equals(1)) {
					for (CommunityMsg m : commMessages) {
						if (m.getCommunity().equals(comm)) {
							System.out.println(m.getSender() + ": " + m.getMessage());
						}
					}
				} else if (opt.equals(2)) {
					System.out.println("Returning...");
					return;
				} else {
					System.out.println("Invalid option.");
					return;
				}

			} else {
				System.out.println("You're not member of  this community.");
				return;
			}
		} else {
			System.out.println("This community doesn't exist.");
		}
	}
	
}