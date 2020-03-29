package core.oops.methodoveriding;

class A3
{
	public void print(int i)
	{
		System.out.println("int");
	}
	public void print(Integer i)
	{
		System.out.println("Integer");
	}
	
	public void print(int i, Double j)
	{
		System.out.println("int +  Double");
	}
	
}

public class AutoboxingOverloadingDemo {

	public static void main(String[] args) {

		A3 a3=new A3();
		a3.print(new Integer(12)); 
		//In below one both type promotion and autoboxing required to work but its not feasible in java 
		//a3.print(new Integer(14),12.3f);//The method print(int, Double) in the type A3 is not applicable for the arguments (Integer, float)
		a3.print(new Integer(14),12.3);
		
		
	}

}
