package core.oops.methodoveriding;

class Employee
{
	int id;
	Employee(int id)
	{
		id=id;//notice the impact without this
		this.id=id;
		
	}
	void setId(int id)
	{
		id=id;//notice the impact without this
		this.id=id;
		
	}
}


public class Test {


	public static void main(String[] args) {
	
		Employee emp=new Employee(12);
		
		System.out.println(emp.id);
		emp.setId(23);
		System.out.println(emp.id);
		
	}
}
