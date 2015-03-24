package collection;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * 
 * @author nagendra.yadav
 *
 */
public class WeakHashMapDemo {
	public static void main(String[] args) {
	
		Map<Puppy,String> whm = new WeakHashMap<Puppy,String>();
		//Map whm = new HashMap();
		//we can not allow duplicate key here. values can be duplicate
		Puppy c1 = new Puppy(1, "Tommy");
		Puppy c2 = new Puppy(2, "AAAA");
		Puppy c3 = new Puppy(3,"AAASSS"); //Caching 
		
		whm.put(c1, "Tommy");
		whm.put(c2, "AAAA");
		whm.put(c3, "AAASSS");
		
		Set set = whm.keySet();
		Iterator itr = set.iterator();
		
		System.out.println("Before #########");
		while(itr.hasNext()) {
			Object key = itr.next();							        
			System.out.println(key + ": " +whm.get(key));
		}
		
		//we do not want c1 and c3 any more.
		c1=null;
		c3=null;
		//calling garbage collector and it is a daemon thread
		System.gc(); //This is request only .  
		
	    set = whm.keySet();
		itr = set.iterator();
		System.out.println("After #########");
		while(itr.hasNext()) {
			Object key = itr.next();							        
			System.out.println(key + ": " +whm.get(key));
		}
	}
}
