package internationalization;

public class BinaryShift {
	
	public static void binaryRepst(int i) {
		if (i == 1) {
			System.out.print(i);
			return;
		}
		binaryRepst(i / 2);
		System.out.print(i % 2);
	}
	public static int solution(int N) {
	     N=N+1;
	     int m=3;
	     int p=2;
	     while(m<=N)
	     {
	    	binaryRepst(N);;
        	 System.out.println();
	         if((m&N)==m)
	         {
	        	 BinaryRepresentation.binaryRepst(N);
	        	 System.out.println();
	             N=N>>p;
			     BinaryRepresentation.binaryRepst(N);
		    	 System.out.println();
	             N=N+1;
	             BinaryRepresentation.binaryRepst(N);
	        	 System.out.println();
	             N=N<<p;
	             BinaryRepresentation.binaryRepst(N);
	        	 System.out.println();
	         }
	         m=m<<1;
	         p=p+1;
	     }
	     return N;
	    }

	public static void main(String[] args) {
		int i=27;
		BinaryRepresentation.binaryRepst(i);
		System.out.println();
		System.out.println(solution(i));

		

	}

}
