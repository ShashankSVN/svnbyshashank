package com.reflection;

class Employee {

	int id;
	String name;

}

public class ObjectCreationByReflection {

	public static void main(String[] args) {
		// Extracting class information using Reflection
		// Object is not created yet its just loaded the class into memory
		Class<Employee> a = Employee.class;
		System.out.println(a.getName());
		System.out.println(a.hashCode());
		Employee employee = null;
		try {
			employee = (Employee) a.newInstance();
			System.out.println(employee.id);
			System.out.println(employee.name);

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
