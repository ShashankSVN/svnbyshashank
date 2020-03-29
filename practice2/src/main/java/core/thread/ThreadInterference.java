package core.thread;

//import java.util.concurrent.atomic.AtomicInteger;

public class ThreadInterference {
	private int count = 0;

	// private AtomicInteger count = new AtomicInteger(0);

	// private volatile int count=0; //its can not solve the problem as its has
	// no control over non atomic operation
	// but yes one solution is to use Atomic Integer
	// another is use synchronized
	public synchronized void increment() {
		// synchronized always read the current value of local variable used
		count++;
		// count.incrementAndGet();
	}

	public static void main(String[] args) {

		ThreadInterference interference = new ThreadInterference();
		interference.doWork();
	}

	public void doWork() {

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					// count++;
					/*
					 * try { Thread.sleep(10); } catch (InterruptedException e)
					 * { e.printStackTrace(); }
					 */
					increment();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					// count++;
					increment();
				}
			}
		});

		t1.start();
		t2.start();
		try {
			t1.join();

			t2.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(count);
	}
}
