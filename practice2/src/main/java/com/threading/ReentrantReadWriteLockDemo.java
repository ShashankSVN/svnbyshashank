package com.threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Mytask implements Runnable {

	Lock readLock;

	public Mytask(Lock readLock) {
		this.readLock = readLock;
	}

	@Override
	public void run() {
		readLock.lock();
		int i = 10;
		while (i > 0) {
			try {
				Thread.sleep(1000);
				System.out.println("Id = " + Thread.currentThread().getId() + " prints " + i);
				i--;
			} catch (InterruptedException e) {
			}
		}
		readLock.unlock();
	}

}

public class ReentrantReadWriteLockDemo {

	public static void main(String[] args) throws InterruptedException {

		ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

		Lock readLock = readWriteLock.writeLock();

		Lock writeLock = readWriteLock.writeLock();

		Thread t1 = new Thread(new Mytask(readLock));
		Thread t2 = new Thread(new Mytask(writeLock));

		t1.start();
		t2.start();

		t1.join();
		t2.join();

	}

}
