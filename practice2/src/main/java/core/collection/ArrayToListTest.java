package core.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToListTest {

	public static void main(String[] args) {

		Integer[] array = new Integer[10];

		for (int i = 0; i <= 9; i++)
			array[i] = i;

		List<Integer> list = Arrays.asList(array);
		list.set(1, 78);// working
		//Structural modification not allowed
		// list.add(1, 78);//Exception in thread "main"
		// java.lang.UnsupportedOperationException

		for (Integer a : list) {
			System.out.print(a + " ");
		}
		System.out.println();
		List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(array));
		list2.set(1, 78);// working
		list2.add(1, 67);// working

		for (Integer a : list2) {
			System.out.print(a + " ");
		}

	}

}
