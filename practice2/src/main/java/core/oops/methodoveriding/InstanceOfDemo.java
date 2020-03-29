package core.oops.methodoveriding;


class A
{
	void method(){System.out.println("A");}
	private void method2(){System.out.println("A");}
}
class B extends A
{
	void method(){System.out.println("B");}
	void method1(){System.out.println("B");}
}
public class InstanceOfDemo {

	public static void main(String[] args) {
		
		B b=new B();
		A a=new B();
		B b1=(B)a;//
		
		//a.method2();
		
		a.method();
		//a.method2();
		b.method1();
		//instance of operator always check object type
		//subclass object is type of subclass itself and superclass too
		if(a instanceof B)
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("NO");
		}

	}

}
