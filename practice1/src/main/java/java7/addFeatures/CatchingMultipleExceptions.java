package java7.addFeatures;

public class CatchingMultipleExceptions {

	public static void main(String[] args) {
		// before java 1.7
		try {
			Class.forName("oracle.odbc.jdbc.OracleDriver").newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		// after java 1.7 Catching Multiple Exceptions
		// try and multi catch
		// Its uses pipe character '|' to separate multiple exception
		try {
			Class.forName("oracle.odbc.jdbc.OracleDriver").newInstance();

			// The exception FileNotFoundException is already caught by the
			// alternative IOException
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
