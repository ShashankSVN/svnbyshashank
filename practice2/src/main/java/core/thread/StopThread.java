package core.thread;

import java.util.Scanner;

class Processor extends Thread {
	// to avoid data being cached by thread use volatile with variable
	private volatile boolean running = true;
	public void run() {
		while (running) {
			System.out.println("Hello");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void shutDown() {
		running = false;
	}
}

public class StopThread {
	public static void main(String[] args) {

		Processor processor = new Processor();
		processor.start();
		// changing running value
		System.out.println("Press Enter key...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		System.out.println("Calling shutdown");
		processor.shutDown();
		
	}

}
