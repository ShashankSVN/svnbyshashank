package core.collection;

import java.util.ArrayList;
import java.util.List;

public class ExceptionComingIfAddByIndexWithSizeZeroInList {

	public static void main(String[] args) {
	
		List<Integer> integers=new ArrayList<Integer>();
		integers.add(2,3);
		System.out.println(integers);
		/*List<Integer> integers2=new ArrayList<Integer>();
		integers2.add(1);
		integers2.add(2,3);
		integers2.add(2);
		System.out.println(integers2);*/
		//Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 2, Size: 0
		
	}

}
