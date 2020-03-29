package com.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class SerializeHashmap {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");

		System.out.println(map.size());

		String filePath = "D:\\LockFolder\\codebase\\svnbyshashank\\trunk\\xtest\\src\\test\\java\\com\\java\\testserializatoin.txt";

		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new FileOutputStream(new File(filePath)))) {
			objectOutputStream.writeChars("");
			System.out.println(map);
			objectOutputStream.writeObject(map);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try (ObjectInputStream objectInputStream = new ObjectInputStream(
				new FileInputStream(new File(filePath)))) {

			Map<String, String> newMap = (Map<String, String>) objectInputStream
					.readObject();

			System.out.println(newMap);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
