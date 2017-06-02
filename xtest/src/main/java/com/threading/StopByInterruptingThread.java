package com.threading;

//Below is best way to stop thread
public class StopByInterruptingThread implements Runnable {

	@Override
	public void run() {

		while (!Thread.currentThread().isInterrupted()) {
			try {
				System.out.println("Sleeping thread");
				Thread.sleep(100);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt(); // this is mandatory
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new StopByInterruptingThread());
		t1.start();

		Thread.sleep(1000);
		// The added benefit is interrupting sleeps, making thread interruption
		// more responsive.
		t1.interrupt();

	}

}
