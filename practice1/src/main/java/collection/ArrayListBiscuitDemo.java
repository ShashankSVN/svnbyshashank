package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author nagendra.yadav
 * 
 */


public class ArrayListBiscuitDemo {

	public static void main(String[] args) {

		
		
		
		// Generic Declaration
		// collection classes can be used as container for other objects.
		List<Biscuit> list = new ArrayList<Biscuit>(5);
		
		Biscuit biscuit1=new Biscuit(1,"ParleG","sweet","open the packet and eat");
		Biscuit biscuit2=new Biscuit(2,"ParleG","sweet","open the packet and eat");
		Biscuit biscuit3=new Biscuit(3,"ParleG","salty","open the packet and eat");
		Biscuit biscuit4=new Biscuit(4,"ParleG","sweet","open the packet and eat");
		Biscuit biscuit5=new Biscuit(5,"ParleG","salty","open the packet and eat");
		Biscuit biscuit6=new Biscuit(6,"ParleG","sweet","open the packet and eat");
		Biscuit biscuit7=new Biscuit(7,"ParleG","salty","open the packet and eat");
		Biscuit biscuit8=new Biscuit(8,"ParleG","sweet","open the packet and eat");
		Biscuit biscuit9=new Biscuit(9,"ParleG","salty","open the packet and eat");
		
		list.add(biscuit1);
		list.add(biscuit2);
		list.add(biscuit3);
		list.add(biscuit4);
		list.add(biscuit5);
		
		list.add(biscuit6);
		list.add(biscuit7);
		list.add(biscuit8);
		list.add(biscuit9);
		
		//new capacity = (old capacity*3)/2 +1 = 8
		//new capacity = (5*3)/2 +1 = 8
		//new capacity = (8*3)/2 +1 = 13
		

		// size of list
		System.out.println("############################");
		// I want to access it.
		Iterator<Biscuit> it = list.iterator();
		//Iterator can be used to access any collection which implements Collection interface
		while (it.hasNext()) {
			Biscuit element = it.next();
			//list.add("I have tested it!!");
			System.out.println("Biscuit de = " + element);
		}

		System.out.println("############################");

		// retrieving all the elements.jdk 1.5
		for (Biscuit str : list) {
			System.out.println("1 = " + str);
		}

		// retrieving all the elements.
		// fastest retrieval because access as per index of the array.
		//a[0]
		for (int i = 0; i < list.size(); i++) {
			System.out.println("2 = " + list.get(i));
		}

		ListIterator<Biscuit> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			System.out.println("4 = " + listIterator.next());
		}

		// retrieving all the elements.
		// fastest retrieval bec
		
		//boolean b=list.contains("Apple"); //complexity  = O(n)
	}
}
