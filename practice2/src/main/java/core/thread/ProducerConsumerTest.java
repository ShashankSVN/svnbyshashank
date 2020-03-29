package core.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Global {
	int var;
	boolean valueset=false; // acts as semaphore
	
	public synchronized int getVar() {
	if(!valueset)
	{
		try {
			wait();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		System.out.println("Got value: " + var);
		valueset=false;
		notify();
		return var;
	}

	public synchronized void setVar(int var) {

		if(valueset)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.var = var;
		notify();
		valueset=true;
		System.out.println("Set value: " + var);

	}
}

class Producer implements Runnable {
	Global global;

	public Producer(Global global) {
		this.global = global;

	}

	@Override
	public void run() {
		int i = 1;
		while (i <= 10) {
			global.setVar(i);
			i++;
		}

	}

}

class Consumer implements Runnable {
	Global global;

	public Consumer(Global global) {
		this.global = global;
	}

	@Override
	public void run() {
		int i = 1;
		while (i <= 10) { // just to show no of times getVar call
			global.getVar();
			i++;
		}

	}

}

public class ProducerConsumerTest {

	public static void main(String[] args) {
		Global global = new Global();
		Thread t1 = new Thread(new Producer(global));
		Thread t2 = new Thread(new Consumer(global));
		t1.start();
		t2.start();
		
		
		CountDownLatch latch=new CountDownLatch(2);
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		latch.countDown();
		
		CyclicBarrier barrier=new CyclicBarrier(3);
		try {
			barrier.await();
			barrier.await();
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		
		ConcurrentMap concurrentMap = new ConcurrentHashMap();
		Lock lock = new ReentrantLock();
		ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
		Semaphore semaphore = new Semaphore(1);
		
		BlockingQueue queue = new ArrayBlockingQueue(1024);
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Exchanger exchanger = new Exchanger();
	
		
		

	}

}
