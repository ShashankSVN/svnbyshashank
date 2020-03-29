package com.oops;

interface D {

	default void method1() {

	}

	static void method2() {

	}
}

interface E {
	default void method1() {

	}

	static void method2() {

	}
}
/*
interface F extends D,E{

}
*/
class J implements D, E {

	@Override
	public void method1() {
		D.super.method1();
	}

}

public class DiamondProblemInterface {

}
