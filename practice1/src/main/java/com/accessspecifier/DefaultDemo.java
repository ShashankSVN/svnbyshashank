package com.accessspecifier;

/*A variable or method declared without any access control modifier is available to any other class in the same package.*/
class C extends Object {

	void hello() {
		System.out.println("Default access to this method");
	}
}

public class DefaultDemo {
	public static void main(String[] args) {
		C c=new C();
		c.hello();//available like public in same package and like private in other package 

	}

}
