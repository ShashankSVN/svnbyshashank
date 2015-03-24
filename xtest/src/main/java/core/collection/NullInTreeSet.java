package core.collection;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class NullInTreeSet {

	public static void main(String[] args) {
		SortedSet<Integer> integer=new TreeSet<Integer>();
		
		integer.add(null);
	//	integer.add(56787);
		
		System.out.println(integer);
		// Exception in thread "main" java.lang.NullPointerException as null is
		// allowed but comparison can not be happen in case of null so size is
		// only 1 
		// but yes if we create our own comparator we can try to enter more than one null
		// but to preserve set contract only it can duplicate
		
		SortedSet<Integer> integers=new TreeSet<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return 1;
			}
		});
		
		integers.add(null);
		integers.add(null);
		
		System.out.println(integers);
	}

}
