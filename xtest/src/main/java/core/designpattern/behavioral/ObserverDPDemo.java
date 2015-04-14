package core.designpattern.behavioral;

import java.util.ArrayList;
import java.util.List;

interface Subject{
	void registerObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObservers();
	
}

class Product implements Subject{
	
	String type;
	String brand;
	String availablity;
	
	public Product(String type,String brand,String availablity) {
		this.type=type;
		this.brand=brand;
		this.availablity=availablity;
	}
	List<Observer> listOfObservers = new ArrayList<Observer>();

	@Override
	public void registerObserver(Observer observer) {
		listOfObservers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		listOfObservers.remove(observer);
		
	}

	@Override
	public void notifyObservers() {
		for (Observer observer: listOfObservers)
			observer.update(this);
	}

	public String getAvailablity() {
		return availablity;
	}
	public void setAvailablity(String availablity) {
		this.availablity = availablity;
		notifyObservers();
	}

	@Override
	public String toString() {
		
		return this.type +" "+ this.brand+" "+ this.availablity;
	}
}


interface Observer{
	
	void update(Product product);
		
}


class User implements Observer
{
	private String name;
	public User(String name) {
		this.name=name;
	}
	@Override
	public void update(Product product) {//send mail
		
		System.out.println(product);
	}
	
}

public class ObserverDPDemo {

	public static void main(String[] args) {

		Product product=new Product("Laptop","Samsung","NotAvailable");
		User user1=new User("John");
		User user2=new User("Jackey");
		product.registerObserver(user1);
		product.registerObserver(user2);
		product.setAvailablity("Avaialable");
		
		
		
		
	}

}
