package core.thread;

public class CreatingThreadByAnnonynousRunnable {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10;i++)
				{
					
					System.out.println("hello");
				}

			}
		});
		t1.start();
		
	}

}
