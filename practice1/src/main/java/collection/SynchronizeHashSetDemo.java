package collection;


import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author nagendra.yadav
 *    Contract for Set!
 *    
 *   1. it does not allow duplicate elements
 *   2. it uses hashCode
 *   3. It is good for searching and Adding,remove , size the element
 *      O(1) =constant time()
 *   4. This is not ordered!   
 *    *        
 *  TreeSet = log(n)
 */

 
public class SynchronizeHashSetDemo {
		
	public static void main(String[] args) {
		
	//Generic Declaration
    //collection classes can be used as container for other objects
	//16
	//load Factor =.75
	//16*.75=12 
	//when we are trying to add 13th element = capacity will increase by double
		                                     //=16*2=32
	//12 =>>>16	
	Set<String> set=new HashSet<String>();
	
	set.add("Apple");
	set.add("Mango");
	set.add("Orange");
	set.add("Banana");
	set.add("Papaya");
	boolean bbb=set.add("Apple");
	System.out.println("bbb = "+bbb);
	set.add(new String("Apple"));
	
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
	
	Set<String> ssss=Collections.synchronizedSet(set);
	
	 Set<String> readOnlyssss=Collections.unmodifiableSet(set);
//	 readOnlyssss=Collections.unmodifiableSet(set);
	readOnlyssss.add("Sorry!");
	
}  
}	
	