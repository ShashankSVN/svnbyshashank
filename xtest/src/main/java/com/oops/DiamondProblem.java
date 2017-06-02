package com.oops;

class A {
	void method() {

		System.out.println("A");
	}
}

class B {
	void method() {
		System.out.println("B");
	}
}

class C extends A {
	
}

// Diamond problem will becoming when we do multiple inheritance with classes
// assume C extends A and B and we don't have defination in A than on calling C c
// =new C() how jvm decide to call which class method- Ambiguity

public class DiamondProblem {

	public static void main(String[] args) {

		A a = new A();
		a.method();

		A ac = new C();
		ac.method();

		C c = new C();
		c.method();

	}

}
