package core.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


class Emp implements Serializable{
	
	int i;

	@Override
	public String toString() {
		return "Emp [i=" + i + "]";
	}
	
}

public class TestArrayListSerialzation {

	public static void main(String[] args) throws Exception{
	
		
		ArrayList<Emp> arrayList=new ArrayList<Emp>();
		arrayList.add(new Emp());
		arrayList.add(new Emp());
		arrayList.add(new Emp());
		arrayList.add(new Emp());
		arrayList.add(new Emp());
		
		System.out.println(arrayList);

		FileOutputStream fileOutputStream=new FileOutputStream(new File("D:\\LockFolder\\codebase\\svnbyshashank\\trunk\\xtest\\src\\test\\java\\com\\java\\testserializatoin.txt"));
		
		ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);  
		
		objectOutputStream.writeObject(arrayList);
		
		objectOutputStream.close();
		
		FileInputStream fileInputStream=new FileInputStream(new File("D:\\LockFolder\\codebase\\svnbyshashank\\trunk\\xtest\\src\\test\\java\\com\\java\\testserializatoin.txt"));
		
		
		ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
		
		ArrayList<Emp> arrayListFromDeserialization = (ArrayList<Emp>) objectInputStream.readObject();
		
		objectOutputStream.close();
		
		System.out.println("aftre deserialization");
		System.out.println(arrayListFromDeserialization);
		
		
		
		
		
		
		
	
		
		
		

	}

}
