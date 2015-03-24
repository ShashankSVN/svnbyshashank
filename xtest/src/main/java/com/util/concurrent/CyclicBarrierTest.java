package com.util.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class Thread1 implements Runnable {

	private CyclicBarrier barrier;

	public Thread1(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {

		try {
			try {
				barrier.await(10, TimeUnit.MILLISECONDS);
			} catch (TimeoutException e) {
				e.printStackTrace();
			}// one thread start waiting at barrier
			System.out.println("Thread1 start processing");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}

class Thread2 implements Runnable {

	private CyclicBarrier barrier;

	public Thread2(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {

		try {

			barrier.await();
			// Another waiting thread times out while waiting at the
			// CyclicBarrier BrokenBarrierException occur at all await()
			// second thread start waiting at barrier
			System.out.println("Thread2 start processing");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}

public class CyclicBarrierTest {

	public static void main(String[] args) {

		// it is a barrier that all threads must wait at, until all threads
		// reach it, before any of the threads can continue

		System.out.println("Lets tests the Carrier barrier action");

		Runnable runnable = new Runnable() {// it can be another runnable thread
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("runnable thread start executing");
			}
		};

		// The CyclicBarrier supports a barrier action, which is a Runnable that
		// is executed once the last thread arrives.
		// Barrier action happens only The last thread arrives (calls await() )
		// You pass the Runnable barrier action to the CyclicBarrier in its
		// constructor, like this:

		CyclicBarrier barrier = new CyclicBarrier(3, runnable);

		Thread t1 = new Thread(new Thread1(barrier));
		Thread t2 = new Thread(new Thread2(barrier));
		t1.start();
		t2.start();
		try {
			// Thread.sleep(12); // Un comment this for t1 timeout to work
			barrier.await();
			// as main thread reaches this thread waiting count
			// reaches 3 which is given count so all thread
			// released immediately
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main done");

	}

}
