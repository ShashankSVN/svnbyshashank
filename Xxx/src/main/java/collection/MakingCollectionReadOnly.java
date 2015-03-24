package collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MakingCollectionReadOnly {
  public static void main(String[] args) {
	
	    //Generic Declaration
	    //collection classes can be used as container for other objects.		
		List<String> list=new ArrayList<String>(5);
		
		list.add("Apple");
		list.add("Mango");
		list.add("Orange");
		list.add("Banana");
		list.add("Papaya");
		
		//It is returning new refrence of list which is read only 
		List<String> rlist=Collections.unmodifiableList(list);
		
		list.add("Tamato!");
		System.out.println("Tamato is added here!");
		System.out.println(list.hashCode());
		System.out.println(rlist.hashCode());
		rlist.add("Carat!");
	  
  
  }
}
