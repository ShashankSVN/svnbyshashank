package com.accessspecifier;


/*
 * Variables, methods and constructors which are declared protected in a
 * superclass can be accessed only by the subclasses in other package or any
 * class within the package of the protected members' class.
 * 
 * The protected access modifier cannot be applied to class and interfaces.
 * Methods, fields can be declared protected, however methods and fields in
 * a interface cannot be declared protected.
 * 
 * Protected access gives the subclass a chance to use the helper method or
 * variable, while preventing a nonrelated class from trying to use it.
 */
class A extends Object {
	static int i;
	// static Object object;
	int var;
	Integer integer;

	protected void hello() {
		System.out.println("Protected access to this method");
	}

	private void display() {
		Object object = new Object();
		// object.finalize();//finalize not visible here
		A a1 = new A();
		try {
			//we are accessing in package com.accessspecifier and Object in package java.lang
			a1.finalize();// protected method visible only through inheritance in other package
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}

class B extends A{
	public void hello() {//In overriding access visibility can no be increased not decreased
		System.out.println("Public acess to this method");
	}
	private void display() {//private method not taking part into inheritance
		System.out.println("Private acess to this method");
	}
	
}


public class ProtectedDemo {

	public static void main(String[] args) {

		A a1 = new A();

		a1.hello();//protected member visible like public in same package
		
		
		System.out.println(a1.var + " and " + a1.i + " and " + a1.integer);
	}

}
