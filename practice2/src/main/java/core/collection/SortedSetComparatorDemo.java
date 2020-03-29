package core.collection;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetComparatorDemo {

	public static void main(String[] args) {

		SortedSet<Integer> integer=new TreeSet<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return (o1>o2 ? -1 : (o1==o2 ? 0 : 1));
			}
		});
		
		integer.add(32457);
		integer.add(56787);
		
		System.out.println(integer);
		System.out.println(integer.comparator());//return null for default order as in case of comparable

	}

}
