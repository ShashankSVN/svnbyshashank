package core.designpattern.creational;

//If singleton class is loaded by two class loaders, two instance of singleton class will be created, one for each classloader.
//Eager Loading
class Singleton1 {
	private static Singleton1 instance = new Singleton1();

	private Singleton1() {

	}

	public static Singleton1 getInstance() {
		return instance;
	}
}

// lazy loading
class Singleton2 {
	private volatile static Singleton2 instance;

	private Singleton2() {
	}

	public static Singleton2 getInstance() {
		// Double check locking
		if (instance == null) {
			synchronized (Singleton2.class) {
				if (instance == null)
					return instance = new Singleton2();
			}
		}
		return instance;
	}
}

public class SingletonTest {

	public static void main(String[] args) {

		Singleton1 singleton11 = Singleton1.getInstance();
		System.out.println(singleton11.hashCode());
		Singleton1 singleton12 = Singleton1.getInstance();
		System.out.println(singleton12.hashCode());

		Singleton2 singleton21 = Singleton2.getInstance();
		System.out.println(singleton21.hashCode());
		Singleton2 singleton22 = Singleton2.getInstance();
		System.out.println(singleton22.hashCode());

	}

}
