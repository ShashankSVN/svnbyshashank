package collection;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author nagendra.yadav
 * 
 * Contract for Map
 * Key cannot be duplicate
 * Value can be duplicate
 * Key can be null
 * value can be null also 
 *
 */
public class HashMapDemo {
		
	public static void main(String[] args) {
		
	//Generic Declaration
    //collection classes can be used as container for other objects.		
	Map<Integer,String> map=new HashMap<Integer,String>(1);

	TreeMap<K, V>
	
	
	//10 => new Integer(10);
	map.put(10,"Apple");
	map.put(20,"Mango");
	map.put(30,"Orange");
	map.put(80,"Banana");  //new Capacity = (Current Capacity)*.75
	map.put(40,"Papaya");
	map.put(10,"Guava");   // here for key 10 = Apple will be overridden by Guava 
	                       //Key will follow Set contract 
	//How to iterate the map
	
	Set<Integer> allKeys=map.keySet();
	for(Integer key : allKeys){
		String value=map.get(key);
		System.out.println("key = "+key+" , value = "+value);
	}
	
	/*
	//I want to access only values
	//List<String> mapValues=(List<String>)map.values();
	Collection<String> mapValues=map.values();
	for(String value:mapValues){
		System.out.println("Value = "+value);
		
	}
	//Fastest approach to access the hashMap
	
	Set<Entry<Integer,String>> set=map.entrySet();
	
	for(Entry<Integer,String> ele : set){
		System.out.println("ele key ="+ele.getKey());
		System.out.println("ele value ="+ele.getValue());
	}
	
	
	//This can synchronize only set and list
	Map<Integer,String> smap=Collections.synchronizedMap(map);*/
	

	
	
}  
}	
	