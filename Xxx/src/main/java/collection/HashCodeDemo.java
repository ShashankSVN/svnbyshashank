package collection;
class Monkey {
	
	
	
}

public class HashCodeDemo {
	
	public static void main(String[] args) {
		
		
		
		Monkey monkey1=new Monkey();
		Monkey monkey2=new Monkey();
		//we are creating one more reference for monkey1
		Monkey monkey3=monkey1;
		
		System.out.println("1.1 ="+monkey1.hashCode());
		System.out.println(monkey2.hashCode());
		System.out.println("1.1 ="+monkey3.hashCode());
		
		System.out.println(monkey2.hashCode());
		
		System.out.println(monkey2.hashCode());
		System.out.println(monkey2.hashCode());
		System.out.println(monkey2.hashCode());
		System.out.println(monkey2.hashCode());
		System.out.println(monkey2.hashCode());
		System.out.println(monkey2.hashCode());
		System.out.println(monkey2.hashCode());
		System.out.println(monkey2.hashCode());
		System.out.println(monkey2.hashCode());
		System.out.println(monkey2.hashCode());
		
		
		String str1="Jhon"; //Method Area
		String str2=new String("Jhon"); //Heap Area
		//str2=str2.intern();
		
		if(str1==str2) {
			System.out.println("(str1==str2) ="+(str1==str2));
		}else {
			System.out.println("(str1==str2) ="+(str1==str2));
		}
		
		
		//same or different guess it ? 
		System.out.println("str1 = "+str1.hashCode());
		System.out.println("str2 = "+str2.hashCode());
		
		
	}

}
