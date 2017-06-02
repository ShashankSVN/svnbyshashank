package core.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class Print100Task implements Runnable {

	Map<String, String> map;

	public Print100Task(Map<String, String> map) {
		super();
		this.map = map;
	}

	@Override
	public void run() {

		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String a = Thread.currentThread().getName() + i;
			map.put(a, a);
			System.out.println(Thread.currentThread().getName() + ": prints: " + i);
		}
	}

}

public class PlayHashMap {

	public static void main(String[] args) throws InterruptedException {

		Map<String, String> map=new HashMap<>();
		
		map.put(null, null);
		map.put("abc", "abc");
		
		Map<String, String> hashMap = new ConcurrentHashMap<>();
		Print100Task task = new Print100Task(hashMap);

		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		Thread t3 = new Thread(task);

		Runnable yt = () -> {
			hashMap.get("");
		};

		Thread t4Thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Set<Entry<String, String>> set = hashMap.entrySet();

				for (Iterator iterator = set.iterator(); iterator.hasNext();) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Entry<String, String> entry = (Entry<String, String>) iterator.next();
					
					System.out.println("size "+set.size()+" key " + entry.getKey() + "val: " + entry.getValue());

				}

			}
		});

		t1.start();
		t2.start();
		t3.start();
		t4Thread.start();

		t1.join();
		t2.join();
		t3.join();
		t4Thread.join();

	}
}
