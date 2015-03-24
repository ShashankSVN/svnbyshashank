package collection;

import java.util.Scanner;

public class TopThreeRank {

	public static void main(String[] args) {
		int[] rank = {14,2,0};
		int size=rank.length;
		System.out.println("Top three element before insertion");
		for(int i=0;i<size;i++)
			System.out.print(rank[i]+ " ");
		System.out.println("Enter element to be inserted");
		Scanner scanner = new Scanner(System.in);
		int num=scanner.nextInt();
		scanner.close();
		int loc=-1;
		//find location at while element is inserted
		for(int i=0;i<size;i++)
		{
			if(rank[i]>num)
			{
				continue;
			}else{
				loc=i;
				break;
			}
		}
		if(loc==-1)
		{
			System.out.println("enter num is not above top three");
		}
		else
		{
			//shift element to the last
			for(int i=size-1 ; i>loc; i--)
			{
				rank[i]=rank[i-1];
			}
			rank[loc]=num;
		}
		System.out.println("Top three element aftre insertion");
		for(int i=0;i<size;i++)
			System.out.print(rank[i]+ " ");
	}

}
