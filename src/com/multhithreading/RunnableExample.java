package com.multhithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class RunnableRunner implements Runnable {
	
	private int i;
	
	public RunnableRunner(int i) {
		this.i=i;
	}

	@Override
	public void run() {
			System.out.println("Starting Task" + i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Completed Tasks" + i);
	}

}

public class RunnableExample {

	public static void main(String args[]) {
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for(int i=0; i<10 ;i++) {
		executor.submit(new RunnableRunner(i));
		}
		executor.shutdown();
		try {
			executor.awaitTermination(20, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("All Tasks Completed");
		
	}
}
