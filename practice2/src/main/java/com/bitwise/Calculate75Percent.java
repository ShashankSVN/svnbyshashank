package com.bitwise;

public class Calculate75Percent {
	// difference between n >>> 2 and n >> 2 : triple take care of signed
	public static void main(String[] args) {

		int n = 4;

		System.out.println((n >>> 2));

		n = n - (n >>> 2);

		System.out.println(n);

	}
}
