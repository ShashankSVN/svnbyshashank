package core.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class abc
{
	static int i;
	static List<Integer> integers=new ArrayList<Integer>();
	
	
}
class T1 implements Runnable {
	List<Integer> integers;

	T1(List<Integer> integers) {
		this.integers = integers;
	}

	@Override
	public void run() {
		int i = 2;
		while (i != 0) {
			for (int j = 0; j < 10; j++) {
				try {
					System.out.println("T1 is waiting");
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Integer integer = integers.get(j);
				synchronized (integer) {
					integers.set(j, integers.get(j) + 1);
				}

			}
			i--;
		}

	}

}

class T2 implements Runnable {
	List<Integer> integers;

	T2(List<Integer> integers) {
		this.integers = integers;
	}

	@Override
	public void run() {
		int i = 2;
		while (i != 0) {
			for (int j = 0; j < 10; j++) {
				try {
					System.out.println("T2 is waiting");
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Integer integer = integers.get(j);
				synchronized (integer) {
				
					integers.set(j, integers.get(j) + 1);
				}
			}
			i--;
		}

	}

}

public class ThreadUpdatingArrayList {
	public static void main(String[] args) throws InterruptedException {

		long startTime = System.currentTimeMillis();
		List<Integer> integers = new ArrayList<Integer>();
		for (int j = 0; j < 10; j++) {
			integers.add(0);
		}
		//The list being synchronized only means that add, remove etc. operations are synchronized and therefore atomic.
		//It is critical that the user manually synchronize on the returned list when iterating over it.
		//alternate is CopyOnWriteArrayList
		List<Integer> integers1 = Collections.synchronizedList(integers);
		Thread t1 = new Thread(new T1(integers1));
		Thread t2 = new Thread(new T2(integers1));
		t1.start();
		t2.start();
		t1.join();
		t2.join();

		System.out.println(integers);

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime);
		
		float f=1.5f;
		if(f==1.5)
		{
			System.out.println("sjefl");
		}else{
			System.out.println("aash");
		}
		System.out.println("value of i :"+ abc.i);
		System.out.println(abc.integers);

		
	}
}
