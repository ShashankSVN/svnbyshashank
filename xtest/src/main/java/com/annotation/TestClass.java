package com.annotation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class A {

	void print(boolean i) {
		System.out.println("boolean");
		System.out.println(i);
	}

	void print(byte i) {
		System.out.println("byte");
		System.out.println(i);
	}

	void print(short i) {
		System.out.println("short");
		System.out.println(i);
	}

	void print(int i) {
		System.out.println("int");
		System.out.println(i);
	}

	void print(long i) {
		System.out.println("long");
		System.out.println(i);
	}

	void print(float i) {
		System.out.println("float");
		System.out.println(i);
	}

	void print(double i) {
		System.out.println("double");
		System.out.println(i);
	}
	void print(char i) {
		System.out.println("char");
		System.out.println(i);
	}

}

public class TestClass {
	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		list.add("11");
		
		List<String> synList=Collections.synchronizedList(list);
		
		ConcurrentHashMap<String, String> concurrentHashMap=null; 
		
		
		
		A a = new A();
		
		//when we pass 0 its treated as integer unless we specify 
		
		a.print(0);
		short i=1;
		a.print(i);
		long u=1L;
		a.print(u);
		
		
		
		
		a.print(false);
		a.print('A');

	}
}
