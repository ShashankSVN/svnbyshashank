package com.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Human
{
	public Human(/*int i*/) {//java.lang.InstantiationException: com.reflection.Human
		//Reflection need defualt constructor for instance creation
	}
	private void behave()
	{
		System.out.println("Display human bahaviour");
	}
}

public class CallingPrivateUsingReflection {

	public static void main(String[] args){

		Class human=Human.class;
		try {
			Method m=human.getDeclaredMethod("behave", null);
			m.setAccessible(true);
			Object o=null;
			try {
				o = human.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			try {
				m.invoke(o, null);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
	}

}
