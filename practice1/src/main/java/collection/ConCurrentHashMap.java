package collection;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class ConCurrentHashMap {
	public static void main(String[] args) {
		ConcurrentHashMap<Integer,String> map=new ConcurrentHashMap<Integer, String>();
		//map is fail-safe for iterator and it is not syncronized
		 //CopyOnWriteArrayList<E>
		
		map.put(10,"Apple");
		map.put(20,"Mango");
		map.put(30,"Orange");
		map.put(80,"Banana");  //new Capacity = (Current Capacity)*.75
		map.put(40,"Papaya");

		//How to iterate the map
		Set<Integer> allKeys=map.keySet();
		for(Integer key : allKeys){
			String value=map.get(key);
			map.put(70,"Pine apple");
			System.out.println("key = "+key+" , value = "+value);
		}

	}
}
