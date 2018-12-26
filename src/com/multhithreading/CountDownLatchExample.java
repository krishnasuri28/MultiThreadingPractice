package com.multhithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class CountDownLatchProcessor implements Runnable {
	
	private CountDownLatch latch;
	
	public CountDownLatchProcessor(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Started.");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		latch.countDown();
	}
	
}
public class CountDownLatchExample {
	
	public static void main(String args[]) {
		
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(int i=0 ; i<10 ; i++) {
		executor.submit(new CountDownLatchProcessor(latch));
		}
		try {
			latch.await();
			executor.awaitTermination(20,TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		System.out.println("Completed");
	}

}
