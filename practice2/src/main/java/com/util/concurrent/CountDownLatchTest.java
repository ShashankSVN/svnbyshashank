package com.util.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class T1 implements Runnable {
	private CountDownLatch countDownLatch;

	public T1(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		try {
			System.out.println("T1 start running");
			// countDownLatch.await();
			// if the count reached zero and also if the waiting time elapsed
			// before the count reached zero
			// no time exception thrown
			countDownLatch.await(1000, TimeUnit.MILLISECONDS);
			System.out.println("T1  finish");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class T2 implements Runnable {
	private CountDownLatch countDownLatch;

	public T2(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		System.out.println("Thread 2 is starting");
		countDownLatch.countDown();
		System.out.println("Current Count: " + countDownLatch.getCount());
		try {
			System.out.println("Thread 2 is waiting");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		countDownLatch.countDown();
		System.out.println("Current Count: " + countDownLatch.getCount());
		System.out.println("T2  finish");

	}

}

public class CountDownLatchTest {
	public static void main(String[] args) {

		final CountDownLatch countDownLatch = new CountDownLatch(2);
		Thread t1 = new Thread(new T1(countDownLatch));
		Thread t2 = new Thread(new T2(countDownLatch));

		Runnable runnable =new  Runnable() {
			
			@Override
			public void run() {
				try {
					countDownLatch.await();
					System.out.println(Thread.currentThread().getName()+" start executing");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread t3=new Thread(runnable);
		Thread t4=new Thread(runnable);
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main done");

	}

}
