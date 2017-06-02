package core.ds.practice;

public class SmallestSubstringOfStringContainsAllCharacterOfString {

	public static void main(String[] args) {

		String string1 = "this is a test string";
		String string2 = "tist";

		
		
		char[] charString1 = string1.toCharArray();
		char[] charString2 = string2.toCharArray();
		int i = 0;
		for (char s : charString2) {
			int y = 0;
			for (; y < charString1.length; y++) {
				if (s == charString1[y]) {
					break;
				}

			}
			i = (i < y) ? y : i;

		}
		
		System.out.println(i);

		String output = "t stri";

	}

}
