package com.util.concurrent.executor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class checks {

	
	public static void main(String[] args) {

		int[] A = { 1, 2, 3, 4, 1 };
		System.out.println(solution(34569));
		
		System.out.println(String.valueOf(34567));

	}

	public static int solution(int N) {
		
	String str = String.valueOf(N);
	
	int length = str.length();
	
	char[] c=str.toCharArray();
	
	
	//Collections.sort(al, Collections.reverseOrder()); 
	
	Arrays.sort(c);
	
	String sorted=new String(c);
	
	System.out.println(Integer.valueOf(sorted));
	
	
	
	
	
		return Integer.valueOf(sorted) ;
		
		

	}

}
