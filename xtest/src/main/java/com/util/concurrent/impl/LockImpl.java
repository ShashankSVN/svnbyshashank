package com.util.concurrent.impl;

class Lock {

	private boolean isLocked = Boolean.FALSE;

	public void lock() {
		synchronized (this) {
			while (isLocked) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			isLocked = Boolean.TRUE;
		}
	}

	public void unlock() {
		synchronized (this) {
			isLocked = Boolean.FALSE;
			notify();
		}
	}

}

class Process {

	int data = 0;

	ReentrantLock lock = new ReentrantLock();

	void increment() throws InterruptedException {
		for (int i = 1; i < 10; i++) {
			lock.lock();
			data++;
			lock.unlock();
		}
	}

}

public class LockImpl {

	public static void main(String[] args) throws InterruptedException {

		final Process process = new Process();
		Thread t1 = new Thread() {
			public void run() {
				try {
					process.increment();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				try {
					process.increment();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t1.start();
		t2.start();
		t1.join();
		t2.join();

		System.out.println(process.data);
		System.out.println("Main done");

	}
}
