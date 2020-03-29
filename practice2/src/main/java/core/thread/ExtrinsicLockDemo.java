package core.thread;

import java.util.ArrayList;
import java.util.List;

class Work {

	List<Integer> list1 = new ArrayList<Integer>();
	List<Integer> list2 = new ArrayList<Integer>();

	Object lock1 = new Object();
	Object lock2 = new Object();

	/* synchronized */void stageOne()// updating list one
	{
		synchronized (lock1) {

			try {
				Thread.sleep(1);// simulation of something waiting for input
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list1.add(1);

		}

	}

	/* synchronized */void stageTwo()// updating list two
	{
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(2);
		}
	}

	void process() {
		int i = 0;
		while (i < 100) {
			stageOne();
			stageTwo();
			i++;
		}

	}
}

public class ExtrinsicLockDemo {

	public static void main(String[] args) {
		final Work work = new Work();
		System.out.println("Starting...");
		long start = System.currentTimeMillis();
		// work.process(); //test1
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				work.process();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				work.process();
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		System.out.println("time of execution: " + (end - start));
		System.out.println("Size of list1: " + work.list1.size()
				+ " size of list2: " + work.list2.size());

	}

}
