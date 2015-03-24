package collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;


public class LinkedHashSetDemo {
	
	public static void main(String[] args) {
		// write syntax
		//default capacity 16
		//It is Ordered  
		Set<Puppy> set = new LinkedHashSet<Puppy>(10);
		
		// this DS which can hold other object
		Puppy puppy1=new Puppy("Tommy",10 );
		Puppy puppy2=new Puppy("AHH", 12);
		Puppy puppy3=new Puppy("MYY", 5);
		Puppy puppy4=new Puppy("NANY", 3);
		Puppy puppy5=new Puppy("NANY", 3);
		
		//dog4 and dog5 are duplicate elements
		set.add(puppy1);
		set.add(puppy2);
		set.add(puppy3);
		set.add(puppy4);
		set.add(puppy5);
		
		System.out.println("puppy4 . hashCode ()  = "+puppy4.hashCode());
		System.out.println("puppy5 . hashCode ()  = "+puppy5.hashCode());
		
		Iterator<Puppy> iterator=set.iterator();
		
		System.out.println("Accessing data using Iterator interface!");
		while(iterator.hasNext()){
			Puppy puppy=iterator.next();
			System.out.println(puppy);
		}
		
		
		System.out.println("____________-----");
		for(Puppy puppy:set){
			System.out.println(puppy);
		}
		
		Puppy puppy6=new Puppy("NANY", 3);
		
		boolean b=set.contains(puppy6);
		if(b){
			System.out.println("puppy6  found in set!"+puppy6);
		}
		
		System.out.println("Run it");
		 /*   final Entry<K,V> getEntry(Object key) {
		        int hash = (key == null) ? 0 : hash(key.hashCode());
		        for (Entry<K,V> e = table[indexFor(hash, table.length)];
		             e != null;
		             e = e.next) {
		            Object k;
		            if (e.hash == hash &&
		                ((k = e.key) == key || (key != null && key.equals(k))))
		                return e;
		        }
		        return null;
		    } */
		 b=set.contains(puppy1);
		if(b){
			System.out.println(b+"is  found in set!");
		}
		

	}
}


