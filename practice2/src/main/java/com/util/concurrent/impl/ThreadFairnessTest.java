package com.util.concurrent.impl;

import java.util.ArrayList;
import java.util.List;


class FairnesLock {

	boolean isLocked = false;
	Thread lockedBy = null;
	int lockedCount = 0;
	
	List<Long> integers=new ArrayList<Long>();

	public  void lock() throws InterruptedException {
		
		synchronized (this) {
			Thread callingThread = Thread.currentThread();
			integers.add(callingThread.getId());
			System.out.println("Entry thread id "+callingThread.getId());
			while (isLocked ) {
				wait();
				if(Thread.currentThread().getId()!=integers.get(0)){
					wait();
				}
				
			}
			isLocked = true;
			integers.remove(0);
			
		}
		
	}
	public synchronized void unlock() {
				isLocked = false;
				notify();
			
	}

}

class Process3 {

	int data = 0;

	FairnesLock lock = new FairnesLock();

	void increment() throws InterruptedException {
		for (int i = 1; i < 4; i++) {
			lock.lock();
			Thread.sleep(10, 10);
			data++;
			
			lock.unlock();
		}
	}

}

public class ThreadFairnessTest {

	public static void main(String[] args) throws InterruptedException {
		final Process3 process = new Process3();
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
		Thread t3 = new Thread() {
			public void run() {
				try {
					process.increment();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread t4 = new Thread() {
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
		
		t3.start();
		t4.start();
		t1.join();
		t2.join();
		t3.join();
		t4.join();

		System.out.println(process.lock.integers);
		
		System.out.println(process.data);
		System.out.println("Main done");

	}

}
