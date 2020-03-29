package core.designpattern.creational;

import java.io.Serializable;
// we can not clone Enum as Enum are by default singleton
// default Deserialization not happen
enum Singleton implements Serializable,Cloneable{
	singleton;//Eager loading // no modifier allowed by default ??
	int i=10;
	/*private Singleton(){
		
	}*/
	public static Singleton getSingleton(){
		return singleton;
	}
	/*Multiple markers at this line
	- Cannot override the final method from 
	 Enum<Singleton>
	- overrides 
	 java.lang.Enum<com.reflection.Singleton>.clone*/
	
	public  static Singleton clone1() throws CloneNotSupportedException {
		return (Singleton)singleton.clone();//throw java.lang.CloneNotSupportedException
	}
}


public class SingletonEnumDemo {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, CloneNotSupportedException{
//	Singleton singleton= Singleton.getSingleton();
	Singleton singleton=Singleton.singleton;
	//Singleton singleton2=(Singleton)Class.forName("com.reflection.Singleton").newInstance();
	System.out.println(singleton.i=11);
	//Singleton singleton3=Singleton.clone1();
	System.out.println(singleton.hashCode());
	//System.out.println(singleton3.hashCode());
	
	
	//
	
	
		
		
	}
}
