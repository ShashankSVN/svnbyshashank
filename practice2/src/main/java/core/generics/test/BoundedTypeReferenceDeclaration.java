package core.generics.test;

import java.util.ArrayList;
import java.util.List;

public class BoundedTypeReferenceDeclaration {

	
	
	
	public static void main(String[] args) {

		ArrayList<String> arrayList1 = new ArrayList<>();
		// ArrayList<String> arrayList1=new ArrayList<String>();

		List<String> arrayList2 = new ArrayList<>();
		// List<String> arrayList2=new ArrayList<String>();

		// List<Object> arrayList3=new ArrayList<String>(); //Type mismatch:
		// cannot convert from ArrayList<String> to List<Object>

		List<?> arrayList4 = new ArrayList<>();

		List<? extends Thread> arrayList5 = new ArrayList<>();

		List<? super Thread> arrayList6 = new ArrayList<>();

		// List<T super Thread> arrayList7=new ArrayList<>(); // T cannot be
		// resolved to a type : type is used to define in class and methods

		// List<? extends Runnable, Object> arrayList8 = new ArrayList<>();
		// Incorrect number of arguments for type List<E>; it cannot be
		// parameterized with arguments <? extends Runnable, Object>

	}

}
