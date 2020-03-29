package core.thread;

public class DaemonThreadDemo {

	public static void main(String[] args) {

		// When a new thread is created it inherits the daemon status of its
		// parent.
		// Normal thread and daemon threads differ in what happens when they
		// exit.
		// When the JVM halts any remaining daemon threads are abandoned:
		// finally blocks are not executed,
		// stacks are not unwound - the JVM just exits.

		// Daemon thread in java is a service provider thread that provides
		// services to the user thread. Its life depend on the mercy of user
		// threads i.e. when all the user threads dies, JVM terminates this
		// thread automatically.

		// There are many java daemon threads running automatically e.g. gc,
		// finalizer etc.

		// You can see all the detail by typing the jconsole in the command
		// prompt. The jconsole tool provides information about the loaded
		// classes, memory usage, running threads etc.

		// It provides services to user threads for background supporting tasks.
		// It has no role in life than to serve user threads.
		// Its life depends on user threads.
		// It is a low priority thread.

		Runnable runnable1 = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("Try is executing");
					Thread.sleep(1000);

				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					System.out.println("Finally executed");
				}
			}
		};
		Thread thread = new Thread(runnable1);
		thread.setDaemon(true);
		thread.start();

	}

}
