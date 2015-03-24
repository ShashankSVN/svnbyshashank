package core.thread;

class Com {
	private Object resource1;
	private Object resource2;

	public Com(Object resource1, Object resource2) {
		this.resource1 = resource1;
		this.resource2 = resource2;
	}

	void method1() {
		synchronized (resource1) {

			System.out.println(Thread.currentThread().getName()
					+ " got lock for resouce1");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized (resource2) {
				System.out.println(Thread.currentThread().getName()
						+ "thread1 got lock for resouce2");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	void method2() {
		synchronized (resource2) {
			System.out.println("thread2 got lock for resouce2");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized (resource1) {
				System.out.println("thread2 got lock for resouce1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

class Thread1 extends Thread {
	Com com;

	public Thread1(Com com) {
		this.com = com;
		this.setName("thread1");
	}

	public void run() {
		com.method1();
	}

}

class Thread2 extends Thread {

	Com com;

	public Thread2(Com com) {
		this.com = com;
		this.setName("thread2");
	}

	public void run() {
		com.method2();
	}
}

public class DeallockDemo {
	
	public static void main(String[] args) throws InterruptedException {

		Com com = new Com(new Object(), new Object());
		Thread1 t1 = new Thread1(com);
		Thread2 t2 = new Thread2(com);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("No dead lock");

	}

}
