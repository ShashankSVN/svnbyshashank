package core.generics.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericsFeaturesTest {

	public static void main(String[] args) {
		// Generic added type safety in Collections

		// using Generic no need to do type casting

		List list = new ArrayList();

		list.add("A");
		list.add("B");

		// client code to iterate happy scenario

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			// casting is needed by client
			String object = (String) iterator.next();
			System.out.println(object);

		}

		list.add(12);

		// non happy scenario
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			String object = (String) iterator.next();

			// Client expecting only string but integer was also present not
			// type safe
			// Exception in thread "main" java.lang.ClassCastException:
			// java.lang.Integer cannot be cast to java.lang.String
			System.out.println(object);

		}

		List<String> list2 = new ArrayList<>();
		list2.add("A");
		list2.add("B");
		// list2.add(12); compilation error : type safety provided by generic

		for (Iterator<String> iterator = list2.iterator(); iterator.hasNext();) {
			String string = iterator.next(); // no type casting needed
			System.out.println(string);

		}

	}

}
