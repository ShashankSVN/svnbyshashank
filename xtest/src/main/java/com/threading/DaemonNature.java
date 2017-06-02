package com.threading;

public class DaemonNature implements Runnable {

	// Daemon nature?
	//
	// If parent thread is non daemon then child thread are also non daemon.
	//
	// The Java Virtual Machine exits when the only threads running are all
	// daemon threads.

	// if thread is isAlive() then IllegalThreadStateException will be thrown on
	// changing daemon nature.
	//
	// We can not set main thread as daemon as its already started and in live
	// state. By default main thread is non daemon.
	
	// if we join child thread to main thread and no matter 

	@Override
	public void run() {

		while (true) {
			try {
				System.out.println("Sleeping thread");
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}

	public static void main(String[] args) {

		Thread t1 = new Thread(new DaemonNature());
		// Change 1
		// t1.setDaemon(true);
		t1.start();
		// Change 2 with Change 1
		// try {
		// t1.join();  -- this makes t1 to finish before main thread - dame
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// t1.setDaemon(true); we can not set nature daemon after starting

	}

}
