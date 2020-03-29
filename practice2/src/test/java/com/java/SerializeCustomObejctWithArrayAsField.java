package com.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

class Student implements Serializable {
	
	private static final long serialVersionUID = 5416829592934766332L;
	int rollNo;
	transient String name;
	int[] contactNumbers;

	public Student(int rollNo, String name, int[] contactNumbers) {
		this.rollNo = rollNo;
		this.name = name;
		this.contactNumbers = contactNumbers;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name
				+ ", contactNumbers=" + Arrays.toString(contactNumbers) + "]";
	}

}

public class SerializeCustomObejctWithArrayAsField {

	public static void main(String[] args) {

		String filePath = "D:\\LockFolder\\codebase\\svnbyshashank\\trunk\\xtest\\src\\test\\java\\com\\java\\testserializatoin.txt";
		int[] array = { 1, 2, 3, 4 };
		Student student = new Student(1, "Archit", array);

		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new FileOutputStream(new File(filePath)))) {
			objectOutputStream.writeChars("");
			System.out.println(student);
			objectOutputStream.writeObject(student);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try (ObjectInputStream objectInputStream = new ObjectInputStream(
				new FileInputStream(new File(filePath)))) {

			Student student2 = (Student) objectInputStream.readObject();

			System.out.println(student2);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
