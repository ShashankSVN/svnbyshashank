package core.oops.methodoveriding;


class A1
{
	public static void print(int  i)
	{
		System.out.println("A");

	}
	public Object print1(Integer i)
	{
		System.out.println("B");
		return null;
	}
}

class B1 extends A1
{
	//overriding signature should be same
	// not depend on boxing and auto boxing and no type promotion
	public static void print(Integer i)
	{
		System.out.println("B");
	}
	//but with java 5 we have co-variant return type
	public Object print1(Integer i)
	{
		System.out.println("B");
		return null;
	}
}

public class AutoboxingMethodOverride {

	public static void main(String[] args) {
		A1 a=new B1();
		a.print(12);
	//	a.print1(14);
	}

}
