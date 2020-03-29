package core.hashmap;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class OrderInTreeMap {

	public static void main(String[] args) {

		NavigableSet<Integer> set = new TreeSet<>();

		set.add(1);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(7);

		SortedSet<Integer> subset = set.subSet(2,true, 6,true);

		for (Iterator<Integer> iterator = subset.iterator(); iterator.hasNext();) {
			Integer integer = iterator.next();
			System.out.println(integer);

		}

	}

}
