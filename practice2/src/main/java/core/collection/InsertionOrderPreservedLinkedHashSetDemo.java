package core.collection;

import java.util.LinkedHashSet;
import java.util.Set;

public class InsertionOrderPreservedLinkedHashSetDemo {

	public static void main(String[] args) {
		
		/*System.out.println("Aa".hashCode());
	    System.out.println("BB".hashCode());*/
	    
	    System.out.println("AaAa".hashCode());
	    System.out.println("BBBB".hashCode());
	    System.out.println("AaBB".hashCode());
	    System.out.println("BBAa".hashCode());
	    
		Set<String> setStrings=new LinkedHashSet<String>();// [AaAa, BBBB, AaBB, BBAa]
	    setStrings.add("ghvkhds");
		setStrings.add("AaAa");
		setStrings.add("BBBB");
		setStrings.add("jakch");
		setStrings.add("AaBB");
		setStrings.add("BBAa");
		System.out.println(setStrings);
		//[BBAa, AaBB, BBBB, AaAa, ghvkhds, jakch]
		//[ghvkhds, AaAa, BBBB, jakch, AaBB, BBAa]

	}

}
