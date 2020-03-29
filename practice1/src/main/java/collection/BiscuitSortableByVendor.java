package collection;

import java.util.Comparator;
//using Comparator we can sort Biscuit on the basis any attribute of it. 
public class BiscuitSortableByVendor implements Comparator<Biscuit> {

	@Override
	public int compare(Biscuit o1, Biscuit o2) {
		int p=o1.getVendor().compareTo(o2.getVendor());
		return p;
	}

}
