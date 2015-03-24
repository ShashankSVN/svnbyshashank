package com.util.concurrent.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceInvokeAllTest {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {

		List<Callable<String>> tasks = new ArrayList<Callable<String>>();

		for (int i = 0; i < 5; i++) {
			final int j = i;
			tasks.add(new Callable<String>() {
				@Override
				public String call() throws Exception {
					Thread.sleep(100);
					return "Thread " + j;
				}
			});
		}

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		String futureAny = executorService.invokeAny(tasks);
		System.out.println(futureAny);
		
		List<Future<String>> futures = executorService.invokeAll(tasks);

		for (Future<String> future : futures) {
			System.out.println(future.get());
		}

		executorService.shutdown();
	}

}
