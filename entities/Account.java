package entities;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import utilities.MenuEditAccount;

public class Account extends Funcionalities
{
	private String login, password, nickname, address;
	private Integer age;  
	private List<String> friends, sendInvitation, receivedInvitation = new ArrayList<>();
	private List<Community> myCommunities = new ArrayList<>();
	private List<Account> users = new ArrayList<>();
	
	Scanner sc = new Scanner(System.in);
	
	public Account() {
		
	}

	public Account(String login, String password, String nickname) {
		this(login, password, nickname, "", 0, "", null, null, null);
		
	}
	
	public Account(String login, String password, String nickname, String description, Integer age, String address,
			List<String> friends, List<String> sendInvitation,
			List<String> receivedInvitation) {
		this.login = login;
		this.password = password;
		this.nickname = nickname;
		this.description = description;
		this.age = age;
		this.address = address;
		this.friends = friends;
		this.sendInvitation =  new ArrayList<>();
		this.receivedInvitation =  new ArrayList<>();
	}
	

	public String getName() {
		return super.name;
	}
	
	
	public String getDescription() {
		return super.description;
	}
	
	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public List<String> getFriends() {
		return friends;
	}
	
	public List<String> getSendInvitation() {
		return sendInvitation;
	}

	public void setSendInvitation(List<String> sendInvitation) {
		this.sendInvitation = sendInvitation;
	}

	public List<String> getReceivedInvitation() {
		return receivedInvitation;
	}

	public void setReceivedInvitation(List<String> receivedInvitation) {
		this.receivedInvitation = receivedInvitation;
	}
	
	
	
	public List<Community> getCommunities() {
		return myCommunities;
	}
	
	public List<Account> getUsers() {
		return users;
	}
	
	
	
	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return  "Name: " + super.name + "\n" +
	            "Nickname: " + nickname + "\n" +
				"Login: " + login + " \n" +
				"Password: " + password + " \n" +
				"Nickname: " + nickname + " \n" +
				"Description: " + super.description + " \n" +
				"Age: " + age + " \n" +
				"Address: " + address;
	}

	@Override
	public void create() 
	{
		    System.out.println("Name: ");
		    super.name = sc.nextLine();
		    System.out.println("Age: ");
		    this.age = sc.nextInt();
		    sc.nextLine();
		    System.out.println("Address: ");
		    this.address = sc.nextLine();
		    System.out.println("Description: ");
		    super.description = sc.nextLine();
			System.out.println("Login: ");
			this.login = sc.next();
			System.out.println("Password: ");
			this.password = sc.next();
			System.out.println("Nickname: ");
			this.nickname = sc.next();
	}
	

	@Override
	public void delete() {
		super.name = null;
		super.description = null;
		this.age = 0; 
		this.address = null;
		this.login = null;
		this.password = null;
		this.nickname = null;
	}
	
	
	@Override
	public boolean get() {
			if(this.name!=null) {
				return true;
		}
		return false;
	}


	@Override
	public void update() {
		MenuEditAccount menu = new MenuEditAccount();
		Integer option = 0;
		while (option != -1) {
			try {
				menu.pattern();
			    option = sc.nextInt();
			    sc.nextLine();
			switch (option) {
			case 1:
				setName(sc.nextLine());
				break;
			case 2:
				setDescription(sc.nextLine());
				break;
			case 3:
				try {
					setAge(sc.nextInt());
				} catch(InputMismatchException e) {
					System.out.println("Please, input a number.");
					sc.nextLine();
				}
				break;
			case 4:
				setAddress(sc.nextLine());
				break;
			case 5:
				setPassword(sc.nextLine());
				break;
			case 6:
				System.out.println(toString());
				option = -1;
				break;
			default:
				System.out.println("Invalid value.");
				break;
				}
			    
			} catch(InputMismatchException e) {
				System.out.println("Please, input a number.");
				sc.nextLine();
			}
			System.out.println(toString());
		}
		
	}
	
}
