package collection;
/**
 * 
 * @author nagendra.yadav
 *
 */

//Comparable interface should be implement in the class which has to be sorted
public class Temp extends Object implements Comparable<Temp>{
	
  private String name;
  private int age;
  
  public String getName() {
	return name;
  }

  public int getAge() {
	  return age;
  }


public Temp(){
	  
  }
  //to assign initiate state for the object
  //to be created
  public Temp(String name, int age) {
	super(); //constructor calling sequence
	this.name = name; //instance hiding
	this.age = age;
  }
  
  //to assign initiate state for the object
  //to be created
  public Temp(int age,String name) {
	  //This is example for constructor chaining 
	 this(name,age);
	 //Super and this cannot come together because both should be 
	 //first statement inside the constructor definition
	 
  }

  @Override
  //to print current state of the object
  //Puppy pp=new Puppy("abc",34);
  //System.out.println(pp);pp.toString();
  public String toString() {
	  return "Puppy [name=" + name + ", age=" + age + "]";
  }
  
 
  //name="abc" , age=10  //"abc".hashCode() =50+10 = 
   //name ="abc" ,age=30 //"abc".hashCode() =50+30 = 
  @Override
   public int hashCode() {
	  int chashCode=name.hashCode()+age;
      return chashCode;
   }
   //once you decided to override hashCode() , you have to override equals method as well
  
  @Override
	public boolean equals(Object obj) {
	    //type casting
	    Temp second=(Temp)obj;
	    if(this.name.equals(second.name) && this.age==second.age){
	    	return true;
	    }
		return false;
	}
  

  public int compareTo(Temp o){
	  if(age>o.age)
	  return -1;
	  else if(age<o.age)
	  return 1;
	  else
	  return 0;
  }
  
  
}
