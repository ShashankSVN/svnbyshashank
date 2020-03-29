package com.util.concurrent.executor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.util.concurrent.CopyOnWriteArrayListTest;

public class ExecutorServiceInvokeAllTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		List<Callable<String>> tasks = new ArrayList<Callable<String>>();
		for (int i = 0; i < 5; i++) {
			final int j = i;
			tasks.add(new Callable<String>() {
				@Override
				public String call() throws Exception {
					Thread.sleep(1000);
					return "Thread " + j;
				}
			});
		}

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		

		Callable<String> callableTask = () -> {
			return Thread.currentThread().getName() + "special task";

		};
		// Type inference and type safety

		Future<String> future1 = executorService.submit(callableTask);

		System.out.println(future1.get());

		executorService.execute(() -> {
			System.out.println(Thread.currentThread().getName());
		});

		executorService.execute(() -> {
			System.out.println(Thread.currentThread().getName());
		});

		executorService.execute(() -> {
			System.out.println(Thread.currentThread().getName());
		});

		String futureAny = executorService.invokeAny(tasks);
		System.out.println(futureAny);

		List<Future<String>> futures = executorService.invokeAll(tasks);

		for (Future<String> future : futures) {
			System.out.println(future.get());
		}

		executorService.shutdown();
	}

}
