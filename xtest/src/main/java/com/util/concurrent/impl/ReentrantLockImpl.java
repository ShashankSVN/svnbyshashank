package com.util.concurrent.impl;

class ReentrantLock {

	boolean isLocked = false;
	Thread lockedBy = null;
	int lockedCount = 0;

	public synchronized void lock() throws InterruptedException {
		Thread callingThread = Thread.currentThread();
		while (isLocked && lockedBy != callingThread) {
			wait();
		}
		isLocked = true;
		lockedCount++;
		lockedBy = callingThread;
	}

	public synchronized void unlock() {
		if (Thread.currentThread() == this.lockedBy) {
			lockedCount--;

			if (lockedCount == 0) {
				isLocked = false;
				notify();
			}
		}
	}

}

class Process2 {

	ReentrantLock lock = new ReentrantLock();

	void superOuter() throws InterruptedException {
		lock.lock();
		System.out.println("SuperOuter");
		outer();

		lock.unlock();
	}

	void outer() throws InterruptedException {
		lock.lock();
		System.out.println("Outer");
		inner();
		lock.unlock();
	}

	void inner() throws InterruptedException {
		lock.lock();
		System.out.println("Inner");
		superInner();
		lock.unlock();

	}

	void superInner() throws InterruptedException {
		lock.lock();
		System.out.println("SuperInner");
		lock.unlock();

	}

}

public class ReentrantLockImpl {

	public static void main(String[] args) throws InterruptedException {
		
		// Cannot use this in a static context
		// System.out.println(this);

		final Process2 process = new Process2();
		Thread t1 = new Thread() {
			public void run() {
				try {
					process.superOuter();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t1.start();
		t1.join();

		System.out.println("Main done");

	}

}
