package core.serialization;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestSerialization {

	public static void main(String[] args) {

		File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\core\\serialization\\hello.txt");
		Employee employee = new Employee(123, "Megha");
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			objectOutputStream.writeObject(employee);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
