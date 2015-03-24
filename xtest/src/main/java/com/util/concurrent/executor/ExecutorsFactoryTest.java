package com.util.concurrent.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class ExecutorsFactoryTest {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		ExecutorService executorService2 = Executors.newCachedThreadPool();
		

		Runnable t1 = new Runnable() {
			@Override
			public void run() {

				for (int i = 0; i < 5; i++) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("T1 is excuting: " + i);
				}
			}
		};
		Runnable t2 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("T2 is excuting: " + i);
				}

			}
		};

		Callable<String> t3 = new Callable<String>() {

			// The Callable interface is similar to Runnable, in that both are
			// designed for classes whose instances are potentially executed by
			// another thread. A Runnable, however, does not return a result and
			// cannot throw a checked exception.
			@Override
			public String call() throws Exception {

				for (int i = 0; i < 5; i++) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("T3 is excuting: " + i);
				}
				return "Successfull";
			}

		};
		executorService.execute(t1);
		
		// Submits a Runnable task for execution and returns a Future
		// representing that task. The Future's get method will return null upon
		// successful completion.
		Future<?> future1 = executorService.submit(t2);
		
		// Submits a value-returning task for execution and returns a Future
		// representing the pending results of the task. The Future's get method
		// will return the task's result upon successful completion.
		Future<String> future2 = executorService.submit(t3);
		
		try {
			System.out.println(future1.get());
			System.out.println(future2.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		executorService.shutdown();

		System.out.println("Main done");

	}
}
