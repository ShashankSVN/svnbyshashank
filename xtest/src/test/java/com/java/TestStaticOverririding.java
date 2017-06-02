package com.java;

class A {

	public static void m() {

		System.out.println("A's m called");
	}
}

class B extends A {

	public static void m() {
		System.out.println("B's m called");
	}
}

public class TestStaticOverririding {

	public static void main(String[] args) {

		A a = new B();
		a.m();
		B b = (B) a;
		b.m();

	}

}
