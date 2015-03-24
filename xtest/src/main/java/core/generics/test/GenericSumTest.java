package core.generics.test;

import java.lang.Double;
import java.util.HashMap;
import java.util.Map;

class GenericSum<T extends Integer,String>{
	
	T[] y;
	public GenericSum(T[] y) {
		this.y=y;
	}
	
	int sum()
	{
		int sum=0;
		for (int i=0;i<y.length;i++)
		{
			//sum+=  y[i];
		}
		return sum;
	}
	
	
}


public class GenericSumTest {

	public static void main(String[] args) {
		
		
		Map<Integer, String> map=new HashMap<Integer, String>(6);
		Map<? extends Integer,? extends String> map1=new HashMap<Integer, String>(6);
		Map<? super Integer,? super String> map2=new HashMap<Integer, String>(6);
		//map1.put
	//	map=new HashMap<Number, String>(6);

		
	}

}
