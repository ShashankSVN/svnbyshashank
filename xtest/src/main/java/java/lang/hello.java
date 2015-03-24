package java.lang;

import java.util.PriorityQueue;

public class hello {

	public static void main()
	{
		
		Object object=new Object();
		try {
			object.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
