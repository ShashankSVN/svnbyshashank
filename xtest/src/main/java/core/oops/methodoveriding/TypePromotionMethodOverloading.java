package core.oops.methodoveriding;

class A2
{
	public void print(int i)
	{
		System.out.println("int");
	}
	public void print(int i, float j)
	{
		System.out.println("int + float ");
	}
	
	public void print(float i, int j)
	{
		System.out.println("float +  int");
	}
	public void print(float i, float j)
	{
		System.out.println("float +  float");
	}
	
	
}

public class TypePromotionMethodOverloading {

	public static void main(String[] args) {
		
		A2 a2 =new A2();
		a2.print(1.2f,1);
		//a2.print(1.2,1); // not applicable as 1.2 is double
		a2.print(1.2f,1.2f);
		//a2.print(12, 12);//The method print(int, float) is ambiguous for the type A2
		

	}

}
