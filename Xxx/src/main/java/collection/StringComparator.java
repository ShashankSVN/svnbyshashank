package collection;
import java.util.Comparator;


public class StringComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		int p=o1.compareTo(o2);
		if(p!=0)
		return -p;
		return 0;
	}

}
