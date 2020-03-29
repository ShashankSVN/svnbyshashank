package core.ds.sorting;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;

public class PivotInQuick {

	public static void main(String[] args) {

		CountDownLatch latch = new CountDownLatch(2);

		latch.countDown();
		
		latch.countDown();

		PriorityQueue<String> priorityQueue = new PriorityQueue<String>((a, b) -> b.compareTo(a));

		TreeSet<String> treeSet = new TreeSet<String>((a, b) -> b.compareTo(a));

		HashMap<String, String> hashMap = new HashMap<String, String>();

		hashMap.put("A", "Shashank");
		hashMap.put("B", "Akash");
		hashMap.put("C", "Nidhi");
		hashMap.put("D", "Vibhor");

		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		hashMap.entrySet().stream().sorted((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()))
				.forEach((a) -> linkedHashMap.put(a.getKey(), a.getValue()));

		linkedHashMap.forEach((a, b) -> System.out.println(b));

		treeSet.add("Z");
		treeSet.add("H");
		treeSet.add("C");
		treeSet.add("A");
		treeSet.add("H");
		treeSet.add("C");

		treeSet.forEach((a) -> System.out.println(a));

		// Stack<String> stack =

		priorityQueue.add("Z");
		priorityQueue.add("H");
		priorityQueue.add("C");
		priorityQueue.add("A");
		priorityQueue.add("H");
		priorityQueue.add("C");

		while (priorityQueue.size() > 0) {
			System.out.println(priorityQueue.remove());
		}

		/*
		 * priorityQueue.forEach((a) -> { System.out.println(a); });
		 */

		Map<Character, Integer> map = new HashMap<>();

		String name = "Shashank_Aggarwalaaaa";

		char[] arr = name.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			Integer val = map.get(Character.valueOf(arr[i]));
			val = (val == null) ? 1 : val + 1;
			map.put(Character.valueOf(arr[i]), val);
		}

		Set<Character> keys = map.keySet();

		StringBuilder builder = new StringBuilder();
		for (Character key : keys) {

			builder.append(key);
			builder.append(" ");
			builder.append(map.get(key));

			builder.append(" ");
		}

		System.out.println(builder.toString());

		int[] a = { 14, 3, 22, 4, 6, 7, 99 };
		int j = 0;
		for (int i = 0; i < a.length; i++) {

			if (a[i] < a[a.length - 1]) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				j++;
			}
		}
		int temp = a[a.length - 1];
		a[a.length - 1] = a[j];
		a[j] = temp;

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);

		}
		System.out.println("pivot" + j);

	}
}
