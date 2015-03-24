package core.ds.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Stack {
	private int[] A;
	private int top = -1;

	Stack(int size) {
		A = new int[size];
	}

	void push(int x) {
		// checking overflow condition
		if (top == A.length - 1) {
			throw new Error("Stack overflow");
		}
		top++;
	//	System.out.println("print top after push" + top);
		A[top] = x;
	}

	int pop() {
		// checking underflow condition
		if (top == -1) {
			throw new Error("Stack underflow");
		}
		top--;
	//	System.out.println("print top after pop" + top);
		return A[top+1];
	}

	boolean isEmpty() {
		return top == -1 ? true : false;
	}

	int top() {
		return A[top];
	}
	void display()
	{
		for(int i=0;i<=top;i++)
		{
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}

}




public class ArrayAsStack {

	public static void main(String[] args) {
		
		List<Integer> list=new ArrayList<Integer>();
		
		List<Integer> linklist = new LinkedList<Integer>();
		linklist.add(4);
		linklist.remove(new Integer(4));
		linklist.add(56);
		
		list.add(3);
		list.remove(new Integer(3)); 
		list.add(6);
		
		Iterator itr= list.iterator();
		
		while(itr.hasNext())
		{
			System.out.println((Integer)itr.next());
		}
		
		itr= linklist.iterator();
		
		while(itr.hasNext())
		{
			System.out.println((Integer)itr.next());
		}
		
		
		
	/*	
		Stack stack = new Stack(10);
		stack.push(12);
		stack.push(24);
		stack.display();
		stack.pop();
		stack.display();
		System.out.println("top element of stack "+ stack.top());
		stack.pop();
		stack.display();
		System.out.println("top element of stack "+ stack.top());
		
		
	
		*/
		
		
	/*	Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of stack u want");
		int size = s.nextInt();
		Stack stack = new Stack(size);
		String check = "Y";
		while(true)
		{
			System.out.println("want to continue Y/N?");
			check = s.next();
			if(check == "N")
			{
				break;
			}
			else
			{
				
			}
		}*/

	}

}
