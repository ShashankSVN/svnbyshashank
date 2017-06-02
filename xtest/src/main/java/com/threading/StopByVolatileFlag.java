package com.threading;

public class StopByVolatileFlag implements Runnable {
	// volatile does not guarantee data consistency ... race condition can occur
	//
	// i=2;
	//
	// Ti and t2 execute at same moment.
	//
	// i =i +3 this may create race condition in multi core environment
	// CPU read value in register and increment and store to main memory
	//
	//
	// where volatile can be helpful? stopping a thread - when you want happens
	// before relation - which means always read updated value done by previous
	// thread (not necessarily by same moment thread)

	private volatile boolean running = true;

	public void terminate() {
		running = false;
	}

	@Override
	public void run() {
		while (running) {
			try {
				System.out.println("Sleeping...");
				Thread.sleep((long) 150);

				System.out.println("Processing");
			} catch (InterruptedException e) {
				System.out.println("Exception" + e.getMessage());
				running = false;
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {

		StopByVolatileFlag byVolatileFlag = new StopByVolatileFlag();
		Thread t = new Thread(byVolatileFlag);

		t.start();
		Thread.sleep((long) 1500);
		byVolatileFlag.terminate();

		t.join();

	}
}
