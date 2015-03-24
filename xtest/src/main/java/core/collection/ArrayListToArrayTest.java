package core.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListToArrayTest {

	public static void main(String[] args) {
	
		List<Integer> list=new ArrayList<Integer>();
		list.add(12);
		list.add(56);
		list.add(77);
		Object[] array1=list.toArray();
		array1[2]=78;
		for(Object a:array1)
		{
			System.out.print((Integer)a+" ");
			
		}
		array1[2]=78;//new array returned by list.toArray();
		/*Integer[] array2;
		array2=list.toArray(array2);//The local variable array2 may not have been initialized
		 */		
		System.out.println();
		Integer[] array2=new Integer[list.size()];
		array2=list.toArray(array2);
		for(Integer a:array2)
		{
			System.out.print(a+" ");
		}

	}

}
