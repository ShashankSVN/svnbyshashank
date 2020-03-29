package core.generics.test;

import java.util.Collections;

class GenericArray<T>
{
	private Object[] array;
	private T y;
	
	private int pos=0;//at  which new element would be added
	
	GenericArray(int size)
	{
		this.array=new Object[size];
	}
	
	<E extends T> void add(E element)
	{
		array[pos++]=element;
	}
	
	void print()
	{
		for(int i=0;i<pos;i++)
		{
			System.out.println("Element at "+ i + ":"+ (T)array[i]);
		}
	}
	
}

public class GenericArrayTest {

	public static void main(String[] args) {
		
		GenericArray<Number> intArray=new GenericArray<Number>(10);
		intArray.add(12);
		intArray.add(13);
		intArray.add(89);
		intArray.add(67.0);
		intArray.print();
			
		GenericArray<String> strArray=new GenericArray<String>(10);
		strArray.add("shashank");
		strArray.add("Sachin");
		strArray.add("anikit");
		strArray.print();
		
	
		
	}

}
