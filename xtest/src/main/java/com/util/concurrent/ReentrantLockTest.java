package com.util.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Process {

	Lock lock = new ReentrantLock();

	void superOuter() {
		lock.lock();
		System.out.println("SuperOuter");
		outer();

		lock.unlock();
	}

	void outer() {
		lock.lock();
		System.out.println("Outer");
		inner();
		lock.unlock();
	}

	void inner() {
		lock.lock();
		System.out.println("Inner");
		superInner();
		lock.unlock();

	}

	void superInner() {
		lock.lock();
		System.out.println("SuperInner");
		lock.unlock();

	}

}

public class ReentrantLockTest {

	public static void main(String[] args) throws InterruptedException {

		final Process process = new Process();
		Thread t1 = new Thread() {
			public void run() {
				process.superOuter();
			}
		};
		t1.start();
		Thread.sleep(1000);
		System.out.println("Main done");

	}

}
