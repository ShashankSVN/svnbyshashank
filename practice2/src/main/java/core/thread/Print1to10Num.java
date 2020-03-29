package core.thread;

class Common {
	private int i = 1;

	synchronized void printOdd() {
		if (i % 2 == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " prints: " + i);
		i++;
		notify();
	}

	synchronized void printEven() {
		if (i % 2 == 1) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " prints: " + i);
		i++;
		notify();
	}
}

public class Print1to10Num {

	public static void main(String[] args) {
		final Common common = new Common();
		new Thread(new Runnable() {
			@Override
			public void run() {

				Thread.currentThread().setName("Odd Thread");
				int i = 1;
				while (i <=20) {
					common.printOdd();
					i++;
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				Thread.currentThread().setName("Even Thread");
				int i = 1;
				while (i <= 20) {
					common.printEven();
					i++;
				}
			}
		}).start();

	}

}
