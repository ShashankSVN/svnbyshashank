package com.util.concurrent;

import java.util.concurrent.Exchanger;

class ProcessA implements Runnable {

	Exchanger<String[]> exchanger;

	String[] buffer = new String[10];

	public ProcessA(Exchanger<String[]> exchanger) {
		super();
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		try {
			System.out.println(buffer.length);
			for (int i = 0; i < buffer.length; i++)
				buffer[i] = new String(i + "s");
			// at this point this thread start waiting for other thread to reach
			// this exchange point
			buffer = exchanger.exchange(buffer);

			System.out.println("ProcessA current buffer: ");
			for (int i = 0; i < buffer.length; i++)
				System.out.print(buffer[i] + " ");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class ProcessB implements Runnable {

	Exchanger<String[]> exchanger;

	String[] buffer = new String[10];

	public ProcessB(Exchanger<String[]> exchanger) {
		super();
		this.exchanger = exchanger;
	}

	@Override
	public void run() {

		try {
			buffer = exchanger.exchange(buffer);
			Thread.sleep(100);
			System.out.println("ProcessB current buffer: ");
			for (int i = 0; i < buffer.length; i++)
				System.out.print(buffer[i] + " ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class ExchangerTest {
	// A synchronization point at which threads can pair and swap elements
	// within pairs. Each thread presents some object on entry to the exchange
	// method, matches with a partner thread, and receives its partner's object
	// on return. An Exchanger may be viewed as a bidirectional form of a
	// SynchronousQueue.

	// Here are the highlights of a class that uses an Exchanger to swap buffers
	// between threads so that the thread filling the buffer gets a freshly
	// emptied one when it needs it, handing off the filled one to the thread
	// emptying the buffer
	public static void main(String[] args) {

		Exchanger<String[]> exchanger = new Exchanger<String[]>();

		Thread thread1 = new Thread(new ProcessA(exchanger));
		Thread thread2 = new Thread(new ProcessB(exchanger));
		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main done");

	}
}
