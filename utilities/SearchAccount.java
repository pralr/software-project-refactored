package utilities;

import java.util.List;
import entities.Account;

public class SearchAccount implements Specification{

	@Override
	public <T> T search(List<T> users, String login) {
		for(T account : users) {
			if(((Account) account).getLogin().equals(login)) {
				return account;
			}
		}
		return null;
	}
}
