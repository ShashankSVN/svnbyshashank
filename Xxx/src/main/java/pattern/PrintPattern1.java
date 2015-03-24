package pattern;

public class PrintPattern1 {

	public static void main(String[] args) {

		int N = 9;
		for (int i = 1; i <= N; i++) {
			int j = N - i+1;
			
			System.out.format("%" + j + "s", "");
			/*while (j > 0) {
				System.out.print(" ");
				j--;
			}*/
			j = 1;
			while (j <= i) {
				System.out.print(j);
				j++;
			}

			j = i - 1;
			while (j > 0) {
				System.out.print(j);
				j--;
			}
			/*j = N - i;
			while (j > 0) {
				System.out.print(" ");
				j--;
			}*/
			System.out.println();
		}

	}

}
