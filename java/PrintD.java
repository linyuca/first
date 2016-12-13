import java.lang.Thread;

public class PrintD {
	private static int counter = 0;
	public static void main(String[] args) {
		new Thread(() -> {
			for(int i=0; i<10; i++) {
				PrintD.counter ++;	
				System.out.println("*** "+counter);
			}
		}).start();

		while(PrintD.counter < 10) {
			System.out.println("net yet");
			try {
				Thread.sleep(1000);			
			}
			catch (InterruptedException e) {
			System.out.println("Erry "+e);
			};
		}		
		System.out.println("got it");
}}
