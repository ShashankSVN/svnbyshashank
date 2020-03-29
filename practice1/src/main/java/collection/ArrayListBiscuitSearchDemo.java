package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author nagendra.yadav
 * 
 */
public class ArrayListBiscuitSearchDemo {

	public static void main(String[] args) {

		// Generic Declaration
		// collection classes can be used as container for other objects.
		//Default capacity for List is 10
		// int newCapacity = (oldCapacity * 3)/2 + 1;
        //(10*3)/2+1=16
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
		list.add(biscuit9);
		list.add(biscuit9);
		list.add(biscuit9);

		// retrieving all the elements.jdk 1.5
		for (Biscuit str : list) {
			System.out.println("1 = " + str);
		}
		
		boolean b=list.contains(biscuit9);
		System.out.println("B = "+b);
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the id");
		int bid=scanner.nextInt();
		
		System.out.println("Enter the taste");
		String taste=scanner.next();
		
		//here we are creating an object with same content which is present into the ArrayList
		//but reference below Biscuit will be different because of new operatior
		Biscuit sbiscuit=new Biscuit(bid,"ParleG",taste,"open the packet and eat");
		//searching the element inside the list
		// for contains ArrayList looks for equals method provided with Class
		 b=list.contains(sbiscuit);
		if(b){
			System.out.println("Biscuit is there = "+sbiscuit);
		}else{
			System.out.println("Biscuit is not there = "+sbiscuit);
		}
	}
}
