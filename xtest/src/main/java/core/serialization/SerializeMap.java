package core.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class Emp1 implements Serializable {

	String s1;
	String s2;

	public Emp1(String s1, String s2) {
		super();
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public String toString() {
		return "Emp1 [s1=" + s1 + ", s2=" + s2 + "]";
	}

	//it called as reflection method
//	private void writeObject(java.io.ObjectOutputStream s) throws IOException {
//
//		throw new IOException();
//	}

}

public class SerializeMap {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		//key and value both need to volatile
		ConcurrentHashMap<Emp1, String> concurrentHashMap = new ConcurrentHashMap<>();
		for (int i = 0; i < 10; i++) {
			String a = "a" + i;
			Emp1 emp = new Emp1(a, a);

			concurrentHashMap.put(emp, a);
		}
		Set<Entry<Emp1, String>> entrySet = concurrentHashMap.entrySet();
		for (Iterator iterator = entrySet.iterator(); iterator.hasNext();) {
			Entry<Emp1, String> entry = (Entry<Emp1, String>) iterator.next();
			System.out.println("key " + entry.getKey() + "val: " + entry.getValue());
		}

		String myCurrentDir = System.getProperty("user.dir");
		System.out.println(myCurrentDir);
		File f = new File(myCurrentDir + "\\src\\main\\java\\core\\serialization\\hello.txt");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		out.writeObject(concurrentHashMap);

		ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
		ConcurrentHashMap<Emp1, String> concurrentHashMap2 = (ConcurrentHashMap<Emp1, String>) in.readObject();																// called
		entrySet = concurrentHashMap2.entrySet();
		for (Iterator iterator = entrySet.iterator(); iterator.hasNext();) {
			Entry<Emp1, String> entry = (Entry<Emp1, String>) iterator.next();
			System.out.println("key " + entry.getKey() + "val: " + entry.getValue());
		}

	}

}
