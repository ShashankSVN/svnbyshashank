package core.thread;

class Runner extends Thread
{
	@Override
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("hello");
		}
	}
}

public class CreatingThreadByExtendingThread {

	public static void main(String[] args) {
		
		Runner  t1=new Runner();
		t1.start();
		
	}

}
