package com.platform;

import java.util.Properties;
import java.util.Set;

public class UpdatingSystemDefaultProperties {

	public static void main(String[] args) {

		Properties  properties= System.getProperties();
		Set<Object> set=properties.keySet();
		for(Object object:set)
		{
			System.out.println(object+ " -:- "+properties.get(object));
		}
		//Put -Dhello_seperator=XXXXXXX into VM arguments.
		System.out.println(System.getProperty("hello_seperator"));
		
		
	}

}
