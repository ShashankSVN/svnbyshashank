package core.collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

//Does the capacity of ArrayList decrease when we remove elements? NO

//we have no method to determine capacity like we have in vector.capacity();

public class ListSpecificMethodDemo {
	// Get the Java runtime
	static Runtime runtime = Runtime.getRuntime();

	private static void printArrayandMemory(List<Integer> integers)
	{
		// Run the garbage collector
	    runtime.gc();
	    // Calculate the used memory
	    long memory = runtime.totalMemory() - runtime.freeMemory();
	    System.out.println("Used memory is bytes: " + memory + " for arraylist size: " +integers.size());
	    System.out.println(integers);
	}

	public static void main(String[] args) {
	
		//add first 10 element	
		
		Integer integer1=new Integer(1);
		Integer integer2=new Integer(1);
		Integer integer3=new Integer(1);
		Integer integer4=new Integer(1);
		Integer integer5=new Integer(1);
		Integer integer6=new Integer(1);
		Integer integer7=new Integer(1);
		Integer integer8=new Integer(1);
		Integer integer9=new Integer(1);
		Integer integer10=new Integer(1);
		Integer integer11=new Integer(1);
		Integer integer12=new Integer(1);
		Integer integer13=new Integer(1);
		Integer integer14=new Integer(1);
		Integer integer15=new Integer(1);
		Integer integer16=new Integer(1);
		Integer integer17=new Integer(1);
		Integer integer18=new Integer(1);
		Integer integer19=new Integer(1);
		Integer integer20=new Integer(1);
		
		List<Integer> integers=new ArrayList<Integer>();
		integers.add(integer1);
		integers.add(integer2);
		integers.add(integer3);
		integers.add(integer4);
		integers.add(integer5);
		integers.add(integer6);
		integers.add(integer7);
		integers.add(integer8);
		integers.add(integer9);
		integers.add(integer10);
		
		ListSpecificMethodDemo.printArrayandMemory(integers);
		System.out.println("after adding one element");
	   
			integers.add(integer11);
		
	    ListSpecificMethodDemo.printArrayandMemory(integers);
	    System.out.println("after adding nine more element");
	   
		integers.add(integer12);
		integers.add(integer13);
		integers.add(integer14);
		integers.add(integer15);
		integers.add(integer16);
		integers.add(integer17);
		integers.add(integer18);
		integers.add(integer19);
		integers.add(integer20);
		
	    ListSpecificMethodDemo.printArrayandMemory(integers);
	    System.out.println("after removing last 18 element");
		for(int i=19;i>=2;i--)
		{
			integers.remove(i);
		}
	    ListSpecificMethodDemo.printArrayandMemory(integers);
				
	}
}

