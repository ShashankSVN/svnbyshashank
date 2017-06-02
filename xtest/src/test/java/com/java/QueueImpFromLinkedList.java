package com.java;

import java.util.ArrayList;
import java.util.LinkedList;



class MyQueue<T>{
	
	LinkedList<T> linkedList=new LinkedList<T>();
	
	public T dequeue(){
		return linkedList.removeFirst();
	}
	
	public void enqueue(T ob){
		linkedList.add(ob);
	}
	
	
}

public class QueueImpFromLinkedList {

	public static void main(String[] args) {
		
		
		LinkedList<String> linkedList=new LinkedList<String>();
		
		linkedList.add("1");
		linkedList.add("2");
		linkedList.add("3");
		
		System.out.println(linkedList.removeFirst());
		
		System.out.println(linkedList.removeLast());
		
		System.out.println(linkedList);
		

		
		
		
	}

}
