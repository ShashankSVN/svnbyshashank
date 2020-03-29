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

class A extends Object{
	
	A() {
		System.out.println("A constructor called");
	}
}

class B implements Externalizable {
	public B() {
		System.out.println("B constructor called");
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {

	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {

	}
}

class C extends B {
	// To avoid Java serialization you need to implement writeObject() and
	// readObject() method in your Class and need to throw
	// NotSerializableException from those method.

	C() {
		System.out.println("C constructor called");
	
	
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		super.writeExternal(out);
	}
	
}

public class ConstructorChainingInSerialization {

	public static void main(String[] args) {

		B b = new B();
		File file = new File(
				"C:\\mySpace\\codebase\\svnbyshashank\\xtest\\src\\main\\java\\core\\serialization\\hello.txt");
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					new FileOutputStream(file));
			objectOutputStream.writeObject(b);
			objectOutputStream.close();
			System.out.println("Reading start.....");
			ObjectInputStream objectInputStream = new ObjectInputStream(
					new FileInputStream(file));
			objectInputStream.readObject();
			objectInputStream.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
