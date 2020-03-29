package collection;

import java.util.Comparator;

public class TasteDescendingBidDescendingComparator  implements Comparator<Biscuit>{

	@Override
	public int compare(Biscuit o1, Biscuit o2) {
		int p=o2.getTaste().compareTo(o1.getTaste());
		if(p==0) {
			return o2.getBid()-o1.getBid();
		}
		//it would be sorted ascending order
		return p;
	}

}
