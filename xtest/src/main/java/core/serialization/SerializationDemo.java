package core.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SuperEmployee {

	int a;

}

class Employee extends SuperEmployee implements Serializable {

	private static final long serialVersionUID = 924033976165179013L;
	// private static final long serialVersionUID = -7561902492155777887L;
	// without explicit serialVersionUID if class structure changed then during
	// Deserialization JVM throw InvalidClassException
//	private static final long serialVersionUID = 1396789720954491619L;
	private int empId;
	private String name;
	// transient variable are not participating in default serialVersionUID
	// generation
	private transient int panNo;
	private transient int panNo6;
	private transient String panNo2;
	// static variable are not participating in default serialVersionUID
	// generation
	private static int val;
	private static int val7;
	private static int val8;
	// instance variable are participating in default serialVersionUID
	// generation
	// but if we use explicit serialVersionUID and add/remove any variable then
	// deserialization happen successfully
	private int hello;

	public Employee(int empId, String name) {
		System.out.println("Constructor called");
		this.empId = empId;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", panNo=" + panNo + ", panNo6=" + panNo6 + ", panNo2="
				+ panNo2 + ", hello=" + hello + ", a=" + a + "]";
	}

	// method are participating in default serialVersionUID generation
	// but if we use explicit serialVersionUID and add/remove any method even
	// then deserialization happen successfully
	public static void display() {
		System.out.println("grsdhjgkh hvjbknl called");
	}

	public void readResolve() {

		System.out.println("readResolve");

	}

	public void writeReplace() {
		System.out.println("writeReplace");
	}

}

public class SerializationDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		/*
		 * Employee obj = new Employee(12, "hello"); System.out.println("Before");
		 * System.out.println(obj.hashCode()); System.out.println(obj);
		 */

		String myCurrentDir = System.getProperty("user.dir");
		File f = new File(myCurrentDir + "\\src\\main\\java\\core\\serialization\\hello.txt");
		// ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		// out.writeObject(obj);
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
		Employee emp = (Employee) in.readObject();// no constructor called
		System.out.println("After");
		System.out.println(emp.hashCode());
		System.out.println(emp);
		// System.out.println(emp.val8);

	}
}