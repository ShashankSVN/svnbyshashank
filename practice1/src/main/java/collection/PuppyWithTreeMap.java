package collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;


public class PuppyWithTreeMap {
	public static void main(String[] args) {

		
	 Map<Puppy,String> map=new TreeMap<Puppy,String>();
	 //it can only hold object of type Puppy? yes
	 Puppy p1=new Puppy("MMMM",10);
	 Puppy p2=new Puppy("AAAA",12);
	 Puppy p3=new Puppy("CCCC",5);
	 Puppy p4=new Puppy("BBBB",4);
	 Puppy p5=new Puppy("AAAA",12);
	 //adding elements inside the set
	 map.put(p1,"MMMM");
	 map.put(p2,"AAAA");
	 map.put(p3,"CCCC");
	 map.put(p4,"BBBB");
	 map.put(p5,"AAAA");
	 
	 Set<Entry<Puppy,String>> set=map.entrySet();
		
		for(Entry<Puppy,String> ele : set){
			System.out.println("ele key ="+ele.getKey());
			System.out.println("ele value ="+ele.getValue());
		}
		
	 
	}

}
