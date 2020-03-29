package com.util.concurrent.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorTest {
	// The ExecutorService has the following implementation in the
	// java.util.concurrent package:

	// ThreadPoolExecutor
	// ScheduledThreadPoolExecutor - Alternate is
	// Executors.newScheduledThreadPool(12);

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {

		ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(
				10);

		// Creates and executes a ScheduledFuture that becomes enabled after the
		// given delay.

		// Parameters:
		// callable the function to execute
		// delay the time from now to delay execution
		// unit the time unit of the delay parameter
		// Returns:
		// a ScheduledFuture that can be used to extract result or cancel
		// Throws:
		// RejectedExecutionException - if the task cannot be scheduled for
		// execution
		// NullPointerException - if callable is null

		// executorService.schedule(callable, delay, unit)

		List<ScheduledFuture<String>> futures = new ArrayList<ScheduledFuture<String>>();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			final int j = i;
			futures.add(executorService.schedule(new Callable<String>() {
				@Override
				public String call() throws Exception {
					Thread.sleep(100);
					return "Thread " + j;
				}
			}, 100, TimeUnit.MILLISECONDS));
		}

		executorService.shutdown();
		while (executorService.isTerminated() != true) {

		}
		long end = System.currentTimeMillis();
		for (int i = 0; i < futures.size(); i++) {
			System.out.println(futures.get(i).get());
		}
		System.out.println("Time lapsed: " + (end - start));

	}

}
