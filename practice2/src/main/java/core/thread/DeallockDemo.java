package core.thread;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

class Com {
	private Object resource1;
	private Object resource2;

	public Com(Object resource1, Object resource2) {
		this.resource1 = resource1;
		this.resource2 = resource2;
	}

	void method1() {
		synchronized (resource1) {

			System.out.println(Thread.currentThread().getName() + " got lock for resouce1");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized (resource2) {
				System.out.println(Thread.currentThread().getName() + "thread1 got lock for resouce2");
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

class myT implements Runnable {

	SoftReference<Object> reference;

	public myT(SoftReference<Object> reference) {
		this.reference = reference;
	}

	@Override
	public void run() {

		while (true) {
			try {
				System.out.println(reference.get());
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class DeallockDemo {

	public static void main(String[] args) throws InterruptedException {

		Com com = new Com(new Object(), new Object());
		Thread1 t1 = new Thread1(com);
		Thread2 t2 = new Thread2(com);

		Object ob = new Object();

		Object ob2 = new Object();

		Object ob3 = new Object();

		SoftReference<Object> reference = new SoftReference<Object>(ob);

		ob = null;

		new Thread(new myT(reference)).start();

		System.out.println(reference.get());

		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("No dead lock");

	}

}
