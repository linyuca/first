import java.util.concurrent.*;

class WorkThread implements Runnable {
	private String command;

	public WorkThread(String s) {
		this.command = s;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " start:" + command);
		try {
			Thread.sleep(500);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		return this.command;
	}
}

class Test {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(7);
		for (int i=0; i<10; i++) {
			Runnable worker = new WorkThread("linyu " + i);
			executor.execute(worker);
		}
		executor.shutdown();	

		Thread task = new Thread(new WorkThread("linyu"));
		task.start();
	}
}
