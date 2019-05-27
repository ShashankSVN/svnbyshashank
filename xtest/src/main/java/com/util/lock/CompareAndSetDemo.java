package com.util.lock;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;


class MyLock{
	
	AtomicBoolean atomicBoolean=new AtomicBoolean(false);
	
	public boolean lock() {
		
		return atomicBoolean.compareAndSet(false, true);
		
	}
	
	
	AtomicInteger atomicInteger =new AtomicInteger();
	
	void show() {
		atomicInteger.set(12);
		
		atomicInteger.get();
	}
	

	
	
	
}
public class CompareAndSetDemo {

	public static void main(String[] args) {
		
		
		
		
	}
}
