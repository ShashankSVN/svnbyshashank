package collection;
/**
 * 
 * @author nagendra
 *
 */
public class StringHashCodeDemo {
	
	public static void main(String[] args) {
		
		//Create Memory from java heap
		String str1=new String("pranay");
		String str2=new String("pranay");
		
		System.out.println("str1==str2 = "+(str1==str2));
		
		System.out.println("str1 = "+str1.hashCode());
		System.out.println("str2 = "+str2.hashCode());
			
		//Intern pool //Method Area
		String str3="pranay";
		
		System.out.println("str1==str3 = "+(str1==str3));
		
		System.out.println("str3 = "+str3.hashCode());
		
		String str4="pranay";
		System.out.println("str4==str3 = "+(str4==str3));
		System.out.println("str4 = "+str4.hashCode());
		
		//Move String from java heap to intern pool(Method Area)
		str1=str1.intern();
		
		
	}

}
