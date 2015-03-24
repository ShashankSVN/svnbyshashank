package collection;
import java.util.Set;
import java.util.TreeSet;


public class PuppyWithComparatorDemo {
	public static void main(String[] args) {

	PuppyAgeAscending custom=new PuppyAgeAscending();
		
	 Set<Puppy> set=new TreeSet<Puppy>(custom);
	 //it can only hold object of type Puppy? yes
	 Puppy p1=new Puppy("MMMM",10);
	 Puppy p2=new Puppy("AAAA",12);
	 Puppy p3=new Puppy("CCCC",5);
	 Puppy p4=new Puppy("BBBB",4);
	 Puppy p5=new Puppy("AAAA",12);
	 //adding elements inside the set
	 set.add(p1);
	 set.add(p2);
	 set.add(p3);
	 set.add(p4);
	 set.add(p5);
	 
	 //displaying all the elements
	 //p2 and p5 contains different hashCode , that's why we are able 
	 //to add duplicate element in set and violating the it's contract
	 for(Puppy p : set){
		 System.out.println(p.toString());//p.toString();
	 }
	 
	}

}
