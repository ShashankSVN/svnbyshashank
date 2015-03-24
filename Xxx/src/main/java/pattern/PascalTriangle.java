package pattern;

public class PascalTriangle {

	static void displayPascalByRecursion(int rows) {
		System.out.println("Pascal By Recursion: ");
		int i = 0;
		displayOuter(i, rows);
	}

	static void displayOuter(int i, int rows) {
		if (i == rows)
			return;
		else {
			int number = 1;
			System.out.format("%" + (rows - i) * 2 + "s", "");
			displayInner(0,number,i);
			System.out.println();
			displayOuter(i + 1, rows);
			
		}
	}

	static void displayInner(int j,int number, int i) {
		if (j > i)
			return;
		else {
			System.out.format("%4d", number);
			number = number * (i - j) / (j + 1);
			displayInner(j + 1,number, i);
		}
	}
	
	static void displayPascalByIteration(int rows)
	{
		System.out.println("Pascal By Iteration: ");
		for (int i = 0; i < rows; i++) {
			int number = 1;
			System.out.format("%" + (rows - i) * 2 + "s", "");
			for (int j = 0; j <= i; j++) {
				System.out.format("%4d", number);
				number = number * (i - j) / (j + 1);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int rows = 10;
		displayPascalByRecursion(rows);
		System.out.println();
		displayPascalByIteration(rows);
	}

}
