package core.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


class ProducerConsumer
{
	BlockingQueue<Integer> queue= new ArrayBlockingQueue<Integer>(1);
	
	void producer(int i) throws InterruptedException
	{
		queue.put(i);	
		System.out.println("Put:"+ i );
	}
	
	void consumer() throws InterruptedException
	{
		int i = queue.take();
		System.out.println("Got:"+ i );
	}
	
}

public class ProducerConsumerBlockingQueue {

	public static void main(String[] args) {
		
		final ProducerConsumer ob=new ProducerConsumer();
		
		new Thread(new Runnable() {
			@Override
			public void run() {

				int i = 1;
				while (i <=5) {
					try {
						ob.producer(i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					i++;
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 1;
				while (i <= 5) {
					try {
						ob.consumer();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					i++;
				}
			}
		}).start();
		
/*	List<Integer> list = new ArrayList<Integer>(23);
	Object a[] = list.toArray();
	System.out.println("lenght is");
	System.out.println(a.length);
*/	
	

	}

}
