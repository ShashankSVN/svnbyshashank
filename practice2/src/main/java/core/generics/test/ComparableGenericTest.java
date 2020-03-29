package core.generics.test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class Animal implements Comparable<Animal> {
	private int a;
	private int b;
	public Animal(int a, int b) {
		this.a = a;
		this.b = b;
	}
	@Override
	public int compareTo(Animal o) {
		return this.a - o.a;
	}
	@Override
	public String toString() {
		return this.a + " " + this.b;
	}
	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
	
	
}

class Cat extends Animal {
	private int c;
	public Cat(int a, int b, int c) {
		super(a, b);
		this.c = c;
	}
	@Override
	public String toString() {
		return super.toString() + " " + this.c;
	}

}

class MyComparator implements Comparator<Animal>
{

	@Override
	public int compare(Animal o1, Animal o2) {
		return o1.getA()-o2.getA();
	}
	
}

public class ComparableGenericTest {
	public static void main(String[] args) {
		List<Animal> list = new ArrayList<Animal>();
		list.add(new Animal(12, 15));
		list.add(new Animal(11, 15));
		list.add(new Animal(7, 15));
		list.add(new Animal(82, 15));
		Collections.sort(list);
		for (Animal a : list) {
			System.out.println(a);
		}
		System.out.println();
		List<Cat> list2 = new ArrayList<Cat>();
		list2.add(new Cat(12, 15, 78));
		list2.add(new Cat(11, 15, 56));
		list2.add(new Cat(7, 15, 90));
		list2.add(new Cat(82, 15, 67));
		// public static <T extends Comparable<? super T>> void sort(List<T>
		// list) {
		// <Cat extends Comparable<Animal>>
		
		 //public static <T> void sort(List<T> list, Comparator<? super T> c)
		Collections.sort(list2,new MyComparator());
		for (Cat a : list2) {
			System.out.println(a);
		}
	}

}
