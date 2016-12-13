import java.util.concurrent.*;

public class Test {
public static void main(String[] args) {
	ExecutorService executor = Executors.newFixedThreadPool(6);

	for(int i=0; i<10; i++) {
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		executor.execute(()-> {
			System.out.println(Thread.currentThread().getName());
		});
	}

	executor.shutdown();
	Thread task = new Thread(()-> { System.out.println(Thread.currentThread().getName()+" thread running");});
	task.start();

	System.out.println(Thread.currentThread().getName()+"main done");
}}
