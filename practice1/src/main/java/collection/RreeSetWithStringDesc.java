package collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class RreeSetWithStringDesc {
	public static void main(String[] args) {

		//Generic Declaration
	    //collection classes can be used as container for other objects.		
		Set<String> set=new TreeSet<String>(new StringComparator());
		
		set.add("Apple");
		set.add("Mango");
		set.add("Orange");
		set.add("Banana");
		set.add("Papaya");
		set.add("Papaya");
		
		//size of list
		System.out.println("############################");
		//I want to access it.
		Iterator<String> it=set.iterator();
		while(it.hasNext()){
			String element=it.next();
			System.out.println("3 = "+element);
		}
		
		System.out.println("One new Banana is added now!");
		set.add("Banana");
		
		System.out.println("############################");
		//retrieving all the elements.
		for(String str : set){
			System.out.println("1 = "+str);
		}
		
	}	

}
