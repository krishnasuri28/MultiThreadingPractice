package com.multhithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {
	
	private int id;
	
	public Processor(int id) {
		this.id = id;
	}

	@Override
	public void run() {
	
		System.out.println("Starting:" + id);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed:" + id);
	}
	
}

public class FixedThreadPoolExample {
	
	public static void main (String args[]) {
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for(int i = 0 ;i<10 ; i++) {
			executor.submit(new Processor(i));
		}
		executor.shutdown();
		try {
			executor.awaitTermination(20, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
