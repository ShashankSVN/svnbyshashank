package core.generics.test;

import java.io.Serializable;

//class declaration
class A<T extends Object> {

	public void show(T ob) {
		System.out.println(ob.toString());
	}
}

// class declaration
class B<T> {

	public void show(T ob) {
		System.out.println(ob.toString());
	}
}

// class declaration
/*
 * class C<T super Object> { //not valid
 * 
 * public void show(T ob) { System.out.println(ob.toString()); } }
 */

class D<T extends Runnable> {

	public void show(T ob) {
		System.out.println(ob.toString());
	}
}

class E<T extends Runnable & Serializable> {

	public void show(T ob) {
		System.out.println(ob.toString());
	}
}

class F<T extends Object & Runnable> {

	public void show(T ob) {
		System.out.println(ob.toString());
	}
}

/*
 * class G<T extends Runnable & Object> { The type Object is not an interface;
 * it cannot be specified as a bounded parameter
 * 
 * public void show(T ob) { System.out.println(ob.toString()); } }
 */

class H<T extends Object, Runnable> { // The type parameter Runnable is hiding
										// the type Runnable

	public void show(T ob) {
		System.out.println(ob.toString());
	}
}

public class GenericClassDeclarationTest {

	public static void main(String[] args) {
		// // reference declaration using custom base generic class
		A<Thread> a1 = new A<Thread>();
		A<Object> a2 = new A<Object>();

		

	}

}
