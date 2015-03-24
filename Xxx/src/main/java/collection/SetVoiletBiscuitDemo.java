package collection;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author nagendra.yadav
 * 
 */
public class SetVoiletBiscuitDemo {

	public static void main(String[] args) {

		Set<Biscuit> list = new HashSet<Biscuit>();
		
		Biscuit biscuit1=new Biscuit(1,"ParleG","sweet","open the package and eat");
		Biscuit biscuit2=new Biscuit(2,"ParleG","sweet","open the package and eat");
		Biscuit biscuit3=new Biscuit(3,"ParleG","salty","open the package and eat");
		Biscuit biscuit4=new Biscuit(4,"ParleG","sweet","open the package and eat");
		Biscuit biscuit5=new Biscuit(5,"ParleG","salty","open the package and eat");
		Biscuit biscuit6=new Biscuit(6,"ParleG","sweet","open the package and eat");
		Biscuit biscuit7=new Biscuit(7,"ParleG","salty","open the package and eat");
		Biscuit biscuit8=new Biscuit(8,"ParleG","sweet","open the package and eat");
		
		//here below all three biscuit are have same contents but different hashcode
		Biscuit biscuit9=new Biscuit(9,"ParleG","salty","open the package and eat");
		Biscuit biscuit10=new Biscuit(9,"ParleG","salty","open the package and eat");
		Biscuit biscuit11=new Biscuit(9,"ParleG","salty","open the package and eat");
		System.out.println("biscuit9 = "+biscuit9.hashCode());
		System.out.println("biscuit10 = "+biscuit10.hashCode());
		System.out.println("biscuit11= "+biscuit11.hashCode());
		// public native int hashCode();
		//JVM by default assign unique hashCode to each and every newly created object
		//using native hashCode implementation from Object class
		
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
		list.add(biscuit10);
		list.add(biscuit11);

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
		
		Biscuit sbiscuit=new Biscuit(bid,"ParleG",taste,"open the package and eat");
		//searching the element inside the list
		 b=list.contains(sbiscuit);
		if(b){
			System.out.println("Biscuit is there = "+sbiscuit);
		}else{
			System.out.println("Biscuit is not there = "+sbiscuit);
		}
	}
}
