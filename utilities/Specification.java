package utilities;

import java.util.List;

public interface Specification {
	public <T> T search(List<T> T, String name);
}

