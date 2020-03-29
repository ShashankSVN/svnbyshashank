package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author nagendra.yadav
 * 
 */

public class FailFastArrayListDemo {

	public static void main(String[] args) {

		// Generic Declaration
		// collection classes can be used as container for other objects.
		List<String> list = new ArrayList<String>(5);
		list.add("Apple");
		list.add("Mango");
		list.add("Orange");
		list.add("Banana");
		list.add("Papaya");
		list.add("Papaya");
		list.add("Papaya");
		list.add("Papaya");
		System.out.println("############################");
		
		Iterator<String>  list2 = list.iterator();
		int count=3;
		while(list2.hasNext())
		{
			
			System.out.println(list2.next());
			/*if(count==3)
			{
				list2.remove();
				count--;
			}*/
			
		}
		System.out.println("kjasfchgc");
		
		
		Iterator<String>    list3 = list.iterator();

		while(list3.hasNext())
		{
			
			System.out.println(list3.next());
		
			
		}
		
		/*// I want to access it.
		Iterator<String> it = list.iterator();
		//Iterator can be used to access any collection which implements Collection interface
		while (it.hasNext()) {
			String element = it.next();
			list.remove(4);
			System.out.println("3 = " + element);
		}*/
	}
}
