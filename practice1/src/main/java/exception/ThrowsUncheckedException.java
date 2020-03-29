package exception;

import java.io.FileNotFoundException;

public class ThrowsUncheckedException {

	public static void main(String[] args) throws FileNotFoundException {
	
		//If we explicitly throw a exception we must need to declare or catch
		//below is unchecked exception demanding norms same as Checked exception
		throw new FileNotFoundException();
		
		//throw new ClassNotFoundException();
		

	}

}
