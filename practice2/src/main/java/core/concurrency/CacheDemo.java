package core.concurrency;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class CacheObject<T> {
	private long lastAccessed;
	private T object;

	public CacheObject(T object) {
		this.lastAccessed = System.currentTimeMillis();
		this.object = object;
	}

	public long getLastAccessed() {
		return lastAccessed;
	}

	public T getObject() {
		this.lastAccessed = System.currentTimeMillis();
		return object;
	}
}

class MyCache<K, V> {
	// Same as Collections.synchonisedMap expect we synchronized iterator too.

	private Map<K,CacheObject<V>> map = new HashMap<K, CacheObject<V>>();

	public void put(K key, V value) {
		synchronized (map) {
			map.put(key, new CacheObject<V>(value) );
		}
	}

	public void remove(K key) {
		synchronized (map) {
			map.remove(key);
		}
	}

	public V get(K key) {
		return map.get(key).getObject();
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
	public void clean() throws SecurityException, NoSuchFieldException{
		synchronized (map) {
			Iterator<K> iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				K key = iterator.next();
				CacheObject<V> value = map.get(key);
				if(System.currentTimeMillis()-value.getLastAccessed()>=1000){
					iterator.remove();
				}
			
			}
		}
	}
}


public class CacheDemo {

	public static void main(String[] args) throws SecurityException,
			NoSuchFieldException, InterruptedException {
		MyCache<Integer, String> map = new MyCache<Integer, String>();
		map.put(10, "Apple");
		map.put(20, "Mango");
		map.put(30, "Orange");
		map.put(40, "Papaya");
		map.put(80, "Banana");
		Thread.sleep(1000);
		map.clean();
		map.iterate();

	}
}
