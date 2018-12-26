package com.multhithreading;

class ThreadRunner extends Thread{

	@Override
	public void run() {
		for (int i=0 ; i<10 ; i++) {
			System.out.println("Hello" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadExample {
	
	public static void main (String args[]) {
		ThreadRunner run1 = new ThreadRunner();
		run1.start();
		ThreadRunner run2 = new ThreadRunner();
		run2.start();
	}
}
