package core.serialization;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Student extends Object implements Externalizable{

	private int id;
	private String name;

	public Student() {
		// for Externalizable default constructor required
		//constructor must be public
		System.out.println("default constructor call");
	}

	public Student(int id, String name) {
		System.out.println("parameter Constructor called");
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "EmpId: " + id + "\tName: " + name;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("writeExternal call");
		//only those who participate in write External can be read in read External
		out.write(id);
		// out.writeObject(name);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("readExternal call");
		id = in.read();
	 name=(String)in.readObject();
	}
}

public class ExternalizableDemo {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		Student obj = new Student(12, "hello");
		File f = new File("C:\\mySpace\\codebase\\svnbyshashank\\xtest\\src\\main\\java\\core\\serialization\\hello.txt");
		System.out.println("Writing start...");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		out.writeObject(obj);
		out.close();
		System.out.println("Reading start...");
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
		Student student = (Student) in.readObject();
		System.out.println(student);
		in.close();
	}
}
