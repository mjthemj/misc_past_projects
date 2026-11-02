

import java.util.Comparator;

public class StringComparator implements Comparator<String> {

	@Override
	public int compare(String arg1, String arg2) {
		return arg1.compareTo(arg2);
	}
}
