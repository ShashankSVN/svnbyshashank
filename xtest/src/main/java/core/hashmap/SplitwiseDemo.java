package core.hashmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SplitwiseDemo {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3);

		// Old school
		long startTime = System.currentTimeMillis();

//		for (Integer i : list)
//			for (int j = 0; j < i; j++)
//				System.out.println(i * j);
		for (Integer i : list)
		    System.out.println(i);

		long endTime = System.currentTimeMillis();

		System.out.println("time " + (endTime - startTime));
		
		startTime = System.currentTimeMillis();
		// "Modern"
		/*list.forEach(i -> {
			IntStream.range(0, i).forEach(j -> {
				System.out.println(i * j);
			});
		});*/
		
		list.forEach(System.out::println);

		endTime = System.currentTimeMillis();

		System.out.println("time " + (endTime - startTime));
	}

}
