package com.util.concurrent;

import java.util.concurrent.PriorityBlockingQueue;

class Employee implements Comparable<Employee> {
	public int experiance;

	public Employee(int experiance) {
		this.experiance = experiance;
	}

	@Override
	public int compareTo(Employee o) {
		int thisVal = this.experiance;
		int anotherVal = o.experiance;
		return (thisVal<anotherVal ? 1 : (thisVal==anotherVal ? 0 : -1));
		//return this.experiance-o.experiance;
	}

	public String toString() {
		return "Employee with experiance: " + experiance;
	}
}

public class PriorityBlockingQueueTest {

	public static void main(String[] args) {

		final PriorityBlockingQueue<Employee> priorityBlockingQueue = new PriorityBlockingQueue<Employee>(
				4);
		
		Thread adder = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i =1; i <= 10; i++) {
					priorityBlockingQueue.put(new Employee(i * 2));
					
				}

			}
		});

		Thread remover = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					//its trying to simulate the priority 
					Thread.sleep(0,1);
					for (int i = 1; i <= 3; i++) {
						System.out.println(priorityBlockingQueue.take());
					}
					Thread.sleep(0,1);
					for (int i = 4; i <= 6; i++) {
						System.out.println(priorityBlockingQueue.take());
					}
					Thread.sleep(0,1);
					for (int i = 7; i <= 10; i++) {
						System.out.println(priorityBlockingQueue.take());
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		adder.start();
		remover.start();
		try {
			adder.join();
			remover.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main done");

	}
}
