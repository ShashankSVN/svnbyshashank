package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;



class Student{
	
	private int studentId;

	private String name;
	
	private int age;
	
	Student()
	{
		System.out.println("Default Constructor");
	}
	Student(int studentId,String name,int age)
	{
		this.studentId=studentId;
		this.name=name;
		this.age=age;
	}
	public int getStudentId() {
		return studentId;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
}

public class JavapTool {

	public static void main(String[] args) {

		Class student=Student.class;
		Constructor[] constructors=student.getDeclaredConstructors();
		for (int i = 0; i < constructors.length; i++) {
			System.out.println(constructors[i]);
		}
		
		Field[]  fields=student.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i]);
		}
		
		Method[] methods =student.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i]);
		}
		
		
		
	}

}
