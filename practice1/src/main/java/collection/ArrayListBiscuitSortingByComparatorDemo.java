package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author nagendra.yadav
 * 
 */
public class ArrayListBiscuitSortingByComparatorDemo {

	public static void main(String[] args) {

		// Generic Declaration
		// collection classes can be used as container for other objects.
		//Default capacity for List is 10
		// int newCapacity = (oldCapacity * 3)/2 + 1;
        //(10*3)/2+1=16
		List<Biscuit> list = new ArrayList<Biscuit>(5);

		Biscuit biscuit1=new Biscuit(9,"ParleG","sweet","open the packet and eat");
		Biscuit biscuit2=new Biscuit(5,"AMECO","sweet","open the packet and eat");
		Biscuit biscuit3=new Biscuit(3,"GOOD DAY","salty","open the packet and eat");
		Biscuit biscuit4=new Biscuit(4,"MONACO","sweet","open the packet and eat");
		Biscuit biscuit5=new Biscuit(2,"ParleG","salty","open the packet and eat");
		Biscuit biscuit6=new Biscuit(6,"AMECO","sweet","open the packet and eat");
		Biscuit biscuit7=new Biscuit(7,"ParleG","salty","open the packet and eat");
		Biscuit biscuit8=new Biscuit(8,"AMECO","sweet","open the packet and eat");
		Biscuit biscuit9=new Biscuit(1,"ParleG","salty","open the packet and eat");
		Biscuit biscuit10=new Biscuit(1,"ParleG","sweet","open the packet and eat");
		Biscuit biscuit11=new Biscuit(1,"MONACO","lickur","open the packet and eat");
		Biscuit biscuit12=new Biscuit(1,"MONACO","smell","open the packet and eat");
		
		list.add(biscuit1);
		list.add(biscuit2);
		list.add(biscuit3);
		list.add(biscuit4);
		list.add(biscuit5);
		list.add(biscuit6);
		list.add(biscuit7);
		list.add(biscuit8);
		list.add(biscuit9);
		list.add(biscuit10);
		list.add(biscuit11);
		list.add(biscuit12);

		// retrieving all the elements.jdk 1.5
		for (Biscuit str : list) {
			System.out.println("1 = " + str);
		}
		
		Collections.sort(list,new BiscuitSortableByVendor());
		
		System.out.println("After sorting");
		// retrieving all the elements.jdk 1.5
		for (Biscuit str : list) {
			System.out.println("1 = " + str);
		}
		
	}
}
