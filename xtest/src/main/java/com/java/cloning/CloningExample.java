package com.java.cloning;

class D {
	int x=11;
	
}
class E implements Cloneable // if not implemented Exception in thread "main" java.lang.CloneNotSupportedException: com.java.cloning.E
// at java.lang.Object.clone(Native Method)
{
	int i=10;
	D d=new D();
	@Override
	// by default deep copy
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
public class CloningExample {
	public static void main(String[] args) throws CloneNotSupportedException {
		E e1=new E();
		E e2=(E)e1.clone();
		System.out.println(e2.equals(e1)); // false
		D d1=e1.d;
		D d2=e2.d;
		System.out.println(d2.equals(d1)); // true

	}

}
