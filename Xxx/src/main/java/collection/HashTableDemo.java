package collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

//1. it is Synchronized
//2. it does not allow null as a key and value.
//3. it default capacity =11
//4 . Legacy class
//5. Enumeration from hashtable is not fail-fast.

/*<p>The iterators returned by the <tt>iterator</tt> method of the collections
 * returned by all of this class's "collection view methods" are
 * <em>fail-fast</em>: if the Hashtable is structurally modified at any time
 * after the iterator is created, in any way except through the iterator's own
 * <tt>remove</tt> method, the iterator will throw a {@link
 * ConcurrentModificationException}.  Thus, in the face of concurrent
 * modification, the iterator fails quickly and cleanly, rather than risking
 * arbitrary, non-deterministic behavior at an undetermined time in the future.
 * The Enumerations returned by Hashtable's keys and elements methods are
 * <em>not</em> fail-fast.
 */

public class HashTableDemo {

	public static void main(String[] args) {
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		hashtable.put("1", "India");
		hashtable.put("2", "Canada");
		Set<String> keys = hashtable.keySet();
		Iterator<String> it = keys.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
			// structural modification done but no concurrent modification occur
			hashtable.put("4", "Australia");
			hashtable.remove("1");
		}

		Enumeration<String> enumeration = hashtable.elements();
		// why enumeration is fail-safe?
		// boolean hasMoreElements();
		// nextElement
		while(enumeration.hasMoreElements())
		{
			System.out.println(enumeration.nextElement());
			hashtable.put("0", "America");//fail same iterator
		}
		
		
		
	}

}

// HashMap we can add one null as key and multiple null as values.
// 16
