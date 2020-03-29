package exception;

public class ExceptionChainDemo {
//An application often responds to an exception by throwing another exception. In effect, the first exception causes the second exception.
	public static void main(String[] args) throws Exception {
		
		try
		{
		
			int a=10/0;
		}
		catch(ArithmeticException exception)
		{
			
			exception.printStackTrace();
			throw new Exception();
		}
		

	}

}
