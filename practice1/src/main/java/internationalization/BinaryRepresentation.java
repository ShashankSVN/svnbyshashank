package internationalization;

public class BinaryRepresentation {
	public static void binaryRepst(int i) {
		if (i == 1) {
			System.out.print(i);
			return;
		}
		binaryRepst(i / 2);
		System.out.print(i % 2);
	}

	public static void main(String[] args) {
		binaryRepst(34);
		
		System.out.println();
		//right shift(remove bit  from right most)
		binaryRepst(34>>2);
		
		System.out.println();
		//left shift (add zero to right most)
		binaryRepst(34<<2);
		
		
	}
}
