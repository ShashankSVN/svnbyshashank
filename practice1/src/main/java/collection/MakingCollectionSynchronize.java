package collection;
import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class MakingCollectionSynchronize {
	
	public static void main(String[] args) {
		//Generic Declaration
	    //collection classes can be used as container for other objects.		
		List<String> list=new ArrayList<String>(5);
		
		list.add("Apple");
		list.add("Mango");
		list.add("Orange");
		list.add("Banana");
		list.add("Papaya");
		
			
		//size of list
		
		System.out.println("############################");
		//I want to access it.
		Iterator<String> it=list.iterator();
		while(it.hasNext()){
			String element=it.next();
			System.out.println("3 = "+element);
		}
		
		System.out.println("############################");

		//retrieving all the elements.
		for(String str : list){
			System.out.println("1 = "+str);
		}
		
		//This can synchronize only set and list
		Collection<String> slist=Collections.synchronizedCollection(list);
		//retrieving all the elements.
		for(String str : slist){
			System.out.println("1 = "+str);
		}
	
		//This can synchronize only set and list
		List<String> pplist=Collections.synchronizedList(list);
		//retrieving all the elements.
		for(String str : pplist){
			System.out.println("1 = "+str);
		}
		
	    
	    
	}

}
