package exception;

class MyException extends Exception
{
	public MyException(String str) {
		super(str);
	}
}



public class CustomExceptionDemo {

	static void validate(int a) throws MyException
	{
		
		if(a<18)
			{
			System.out.println("U Dont have Right to vote");
			throw new MyException("U Dont have Right to vote");
			}
		else
			
			System.out.println("U have Right to vote");
	}
	
	public static void main(String[] args) throws MyException {
		
		validate(19);
		validate(39);
		validate(12);
		
		
		

	}

}
