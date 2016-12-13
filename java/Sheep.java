import java.util.concurrent.*;

public class Sheep {
	private int count = 0;
	//private final Object lock = new Object();
	private void report() {
		//synchronized(lock) {
		//synchronized(Sheep.class) {
		synchronized(this) {
		System.out.print((++count) + " ");
		}
		//}
	}

	public static void main(String[] args) {
		ExecutorService service = null;
		
		service = Executors.newFixedThreadPool(20);
		Sheep s = new Sheep();
		for(int i=0; i<10; i++) {
			service.submit(()->s.report());
		}
		service.shutdown();
		try {
		Thread.sleep(500);
		} catch (Exception e) {
			System.out.println("e ");
		}
		System.out.println(" ");
	}}
