package core.thread;

class Runner1 implements Runnable{

	@Override
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("hello");
		}
	}
	
}

public class CreatingThreadByImplRunnable {

	public static void main(String[] args) {
		Thread t1=new Thread(new Runner1());
		Thread t2=new Thread(new Runner1());
		t1.start();
		t2.start();
		try {
			System.out.println("t1 join");
			t1.join();
			// on calling above join next line is not executing until t1 finish
			// but t2 is in progress
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("t2 join");
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Program done");
	}

}
