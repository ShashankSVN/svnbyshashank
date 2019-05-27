package com.util.concurrent.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest extends Object {

	// The ExecutorService has the following implementation in the
	// java.util.concurrent package:

	// ThreadPoolExecutor - Alternate is Executors.newFixedThreadPool(4)
	// ScheduledThreadPoolExecutor

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// However, unless you need to specify all these parameters explicitly
		// for your ThreadPoolExecutor, it is often easier to use one of the
		// factory methods in the java.util.concurrent.Executors class
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(10);
		// Waits if necessary for the computation to complete, and then
		// retrieves its result.
		ExecutorService executorService = new ThreadPoolExecutor(4, 4, 1, TimeUnit.SECONDS, workQueue);
		// ExecutorService executorService =Executors.newFixedThreadPool(1);
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			final int j = i;
			Future<String> future = executorService.submit(new Callable<String>() {
				@Override
				public String call() throws Exception {
					Thread.sleep(100);
					return "Thread " + j;
				}
			});
			// Waits if necessary for the computation to complete, and then
			// retrieves its result.
			// System.out.println(future.get());
		}

		executorService.shutdown();
		while (executorService.isTerminated() != true)
			;
		long end = System.currentTimeMillis();
		System.out.println("Time lapsed: " + (end - start));

	}

}
