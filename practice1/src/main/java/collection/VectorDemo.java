package collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorDemo {
	
	public static void main(String[] args) {
		
		Vector<String> vector=new Vector<String>();
		vector.add("nagendra"); 
		vector.add("Nky");
		vector.add("Gurpreet");
		
		Enumeration<String> en=vector.elements();
		while(en.hasMoreElements()){
			String str=en.nextElement();
			System.out.println(str);
		}
		
		Iterator<String> iterator=vector.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
		    System.out.println("string = "+string);
		    vector.remove("Gurpreet");
		}
		
	}

}
