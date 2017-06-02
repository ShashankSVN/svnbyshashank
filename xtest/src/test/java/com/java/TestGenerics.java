package com.java;

import java.util.ArrayList;

class X {

}

class Y extends X {

}

class Z extends Y {

}

public class TestGenerics {
	public static void main(String[] args) {
		ArrayList<? extends Y> arrayList1 = new ArrayList<Y>();
		ArrayList<? super Y> arrayList2 = new ArrayList<Y>();
		ArrayList<? super Y> arrayList3 = new ArrayList<X>();
		ArrayList<Object> arrayList4 = new ArrayList<Object>();
		arrayList4.add(new X());

	}

}
