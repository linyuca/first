import java.util.concurrent.*;

public class ZooInfo {
	public static void main(String[] args){
	ExecutorService aS = null;
	Runnable aTask = ()-> { System.out.println("in task " + Thread.currentThread().getId()); };
	Runnable t2 = ()-> {System.out.println("in t1 "+Thread.currentThread().getId());};

	System.out.println("process num: "+ Runtime.getRuntime().availableProcessors());
	try {
		aS = Executors.newSingleThreadExecutor();
		aS.execute(aTask);
		aS.execute(t2);
		System.out.println("main " + Thread.currentThread().getId());
	} finally {
		System.out.println("in finally " + Thread.currentThread().getId());
		if (aS != null) aS.shutdown();
	}
}}
