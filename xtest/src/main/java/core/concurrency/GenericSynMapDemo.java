package core.concurrency;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


class SynMap<K,V> {
	// Same as Collections.synchonisedMap expect we synchronized  iterator too.

	private Map<K, V> map = new HashMap<K, V>();

	public void put(K key,  V value) {
		synchronized (map) {
			map.put(key, value);
		}
	}

	public void remove(K key) {
		synchronized (map) {
			map.remove(key);
		}
	}

	public V get(K key) {
		return map.get(key);
	}

	public void iterate() {
		synchronized (map) {
			Iterator<K> iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				K key = iterator.next();
				System.out.println("Key: " + key + " & Value: " + map.get(key));
			}
		}
	}
}

public class GenericSynMapDemo {

	public static void main(String[] args) {

		SynMap<Integer,String> map = new SynMap<Integer,String>();
		map.put(10, "Apple");
		map.put(20, "Mango");
		map.put(30, "Orange");
		map.put(40, "Papaya");
		map.put(80, "Banana"); 
		map.iterate();

	}
}
