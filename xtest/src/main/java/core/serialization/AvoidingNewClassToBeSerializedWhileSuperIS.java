package core.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Super implements Serializable {
	Super() {
		System.out.println("Super called...");
	}
}

//Wants to avoid this to get serialized or deserialized 

class Child extends Super {
	
	
	
	Child() {
		System.out.println("Child called...");
	}
	
	
	
}

public class AvoidingNewClassToBeSerializedWhileSuperIS {

	public static void main(String[] args) {
		
		Child child=new Child();
		
		File file = new File("D:\\eclipse\\svnbyshashank\\xtest\\src\\main\\java\\core\\serialization\\hello.txt");
		
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					new FileOutputStream(file));
			objectOutputStream.writeObject(child);
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
