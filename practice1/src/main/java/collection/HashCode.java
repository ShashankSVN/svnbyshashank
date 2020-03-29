package collection;
class Dog extends Object {
	
  String name;
	
  Dog(String name){
	  this.name=name;
  }
	
  void print(){
	  System.out.println("name = "+name);
  }
	
}

public class HashCode {
	
	public static void main(String[] args) {
		
		Dog dog=new Dog("Tommy");
		
		System.out.println(dog.hashCode());
		
		System.out.println(dog.hashCode());
		
		System.out.println(dog.hashCode());
		
		System.out.println(dog.hashCode());
		
		Dog dog1=new Dog("Tommy");
		
		System.out.println("________--");
		System.out.println(dog1.hashCode());
		System.out.println(dog1.hashCode());
		
		
		System.out.println("________--");
		
		
		Dog dog2=dog1;
		System.out.println(dog2.hashCode());
		if(dog1==dog2){
			System.out.println("Same Dog!");
		}
		
	}

}
