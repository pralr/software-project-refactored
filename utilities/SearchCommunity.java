package utilities;

import java.util.List;

import entities.Community;

public class SearchCommunity implements Specification {

	@Override
	public <T> T search(List<T> communities, String nameCommunity) {
		for(T community : communities) {
			if(((Community) community).getName().equals(nameCommunity)) {
				return community;
			}
		}
		return null;
	}

		

}
