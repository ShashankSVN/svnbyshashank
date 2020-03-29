package com.util.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class Application implements Delayed {

	String date;

	public Application(String date) {
		this.date = date;
	}

	@Override
	public int compareTo(Delayed o) {
		// DateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
		Application application = (Application) o;
		this.date.compareTo(application.date);
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {

		return 0;
	}

}

class Producer1 implements Runnable {
	BlockingQueue<Application> blockingQueue;

	public Producer1(BlockingQueue<Application> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 9; i++) {

				blockingQueue.put(new Application(""));
				System.out.println("Thread Name: "
						+ Thread.currentThread().getName()
						+ " Element inserted: " + String.valueOf(i));
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class Consumer1 implements Runnable {
	BlockingQueue<Application> blockingQueue;

	public Consumer1(BlockingQueue<Application> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 9; i++) {

				System.out.println("Thread Name: "
						+ Thread.currentThread().getName() + " Element taken: "
						+ blockingQueue.take());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

public class DelayQueueTest {

	public static void main(String[] args) {
		
		
		BlockingQueue<Application> blockingQueue = new DelayQueue<Application>();
		Thread t1 = new Thread(new Producer1(blockingQueue));
		Thread t2 = new Thread(new Consumer1(blockingQueue));
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
