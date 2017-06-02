package com.threading;

public class NestingThread implements Runnable {

	// Child thread get daemon nature from parent thread but on parent thread
	// completion does not affect child thread execution

	@Override
	public void run() {
		System.out.println(
				Thread.currentThread().getName() + " started and isDaemon " + Thread.currentThread().isDaemon());
		int i = 1;
		while (i < 4) {
			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {

					for (int j = 0; j < 10000; j++) {
						System.out.println(Thread.currentThread().getName() + " prints " + j + " and isDaemon "
								+ Thread.currentThread().isDaemon());
					}

				}
			});
			t1.setDaemon(false);
			t1.start();

			i++;
		}
	}

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new NestingThread());
		t1.setDaemon(true);
		t1.start();
		Thread.sleep(10);
		// t1.join();

	}

}
