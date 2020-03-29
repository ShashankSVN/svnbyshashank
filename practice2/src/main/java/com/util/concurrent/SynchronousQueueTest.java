package com.util.concurrent;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {

	public static void main(String[] args) {
		final SynchronousQueue<Integer> integer=new SynchronousQueue<Integer>();
		
		Thread t1=new Thread() {
			@Override
			public void run() {
				for(int i=0;i<=10;i++)
					try {
						Thread.sleep(10);
						integer.put(i);
						System.out.println(i+ " entered");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		};
		
		
		
		Thread t2=new Thread() {
			@Override
			public void run() {
				for(int i=0;i<=10;i++)
					try {
						Thread.sleep(10);
						System.out.println(integer.take() + " removed");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		};
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
