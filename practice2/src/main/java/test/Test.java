package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable {

	private int empId;
	private String name;
	
	private Employee() {
	}

	public Employee(int empId, String name) {
		System.out.println("Constructor called");
		this.empId = empId;
		this.name = name;
	}

	@Override
	public String toString() {
		return "EmpId: " + empId + "\tName: " + name;
	}

}

public class Test {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		Employee obj = new Employee(12, "hello");
		System.out.println("Before");
		System.out.println(obj.hashCode());
		System.out.println(obj);
		File f = new File("C:\\mySpace\\hello.txt");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		out.writeObject(obj);
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
		Employee emp = (Employee) in.readObject();//no constructor called
		System.out.println("After");
		System.out.println(emp.hashCode());
		System.out.println(emp);

	}
}
