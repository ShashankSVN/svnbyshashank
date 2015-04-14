package java7.addFeatures;

public class UnderscoresinNumericLiterals {

	public static void main(String[] args) {

		// This feature enables you, to separate groups of digits
		// in numeric literals, which can improve the readability of your code.

		// We can place underscores only between digits
		// we cannot place underscores in the following places
		// At the beginning or end of a number
		// Adjacent to a decimal point in a floating point literal
		// Prior to an F or L suffix
		// In positions where a string of digits is expected
		// cannot put underscores in between the 0x radix prefix

		long creditCardNumber = 1234_5678_90____12_3456L;
		long socialSecurityNumber = 99_9_99_9999L;
		float pi = 3.14_15F;
		long hexBytes = 0xFF_EC_DE_5E;
		long hexWords = 0xCAFE_BABE;
		long maxLong = 0x7fff_ffff_ffff_ffffL;
		byte nybbles = 0b0010_0101;
		long bytes = 0b11010010_01101001_10010100_10010010;

		System.out.println(creditCardNumber);
		System.out.println(socialSecurityNumber);
		System.out.println(pi);
		System.out.println(hexBytes);
		System.out.println(hexWords);
		System.out.println(maxLong);
		System.out.println(nybbles);
		System.out.println(bytes);

	}
}
