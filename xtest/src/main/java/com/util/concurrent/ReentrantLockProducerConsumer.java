package com.util.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Common {
	int data = 0;
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	void producer() {
		for (int i = 0; i < 10; i++) {
			lock.lock();
			data = i;
			lock.unlock();

		}
	}

	void consumer() {
		for (int i = 0; i < 10; i++) {
			lock.lock();
			System.out.println(data);
			lock.unlock();
		}
	}

}

public class ReentrantLockProducerConsumer {

	public static void main(String[] args) {
		final Common common = new Common();

		Thread t1 = new Thread() {
			@Override
			public void run() {
				common.producer();

			}

		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				common.consumer();

			}

		};

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
