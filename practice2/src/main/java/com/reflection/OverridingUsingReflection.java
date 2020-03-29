package com.reflection;

class A
{
	int a=10;
	public void display()
	{
		System.out.println("AAAA");
	}
}

class B extends A
{
	B(){
		//super();
	}
	@Override
	public void display()
	{
		System.out.println("BBBB");
	}
}

public class OverridingUsingReflection {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		A ob=(B)Class.forName("com.reflection.B").newInstance();
		System.out.println(ob.hashCode());
		A ob2=(A)ob;
		System.out.println(ob2.hashCode());
		System.out.println(ob.a);
		
		ob.display();

	}

}
