package core.thread;

class MyTask1 implements Runnable {

	ThreadLocal<Integer> local = new ThreadLocal<Integer>();

	@Override
	public void run() {

		local.set((int) Math.random() % 1000);
		System.out
				.println(Thread.currentThread().getName() + " " + local.get());

	}

}

public class ThreadLocalDemo {

	public static void main(String[] args) {

		// The ThreadLocal class in Java enables you to create variables that
		// can only be read and written by the same thread. Thus, even if two
		// threads are executing the same code, and the code has a reference to
		// a ThreadLocal variable, then the two threads cannot see each other's
		// ThreadLocal variables.
		MyTask1 task = new MyTask1();
		new Thread(task).start();
		new Thread(task).start();
	}

}
