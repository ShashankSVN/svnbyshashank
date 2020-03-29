package java7.addFeatures;

public class StringInSwitchStatement {

	public static void main(String[] args) {

		final String string1 = "One";
		final String string2 = "Two";
		final String string3 = "Three";
		// This won't be possible before java 7
		String userString = "One";
		switch (userString) {
		case "One":
			System.out.println(string1);
			break;
		case "Two":
			System.out.println(string2);
			break;
		case "Three":
			System.out.println(string3);
			break;
		}
		// This won't be possible before java 7
		switch (userString) {
		// case expressions must be constant expressions use final in case
		// reference is using for case
		case string1:
			System.out.println(string1);
			break;
		case string2:
			System.out.println(string2);
			break;
		case string3:
			System.out.println(string3);
			break;
		}
	}

}
