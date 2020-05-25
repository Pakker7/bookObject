package part13.thread;

public class RunThreads {
	public void runBasic() {
		RunnableSample runnable = new RunnableSample();
		ThreadSample thread = new ThreadSample();

		new Thread(runnable).start();
		thread.start();
		System.out.println("RunThreads.runBasic() method is ended.");
	
	}
	
/*	public class runBasic2 {

		RunnableSample[] runnable = new RunnableSample[5];
		ThreadSample[] thread = new ThreadSample[5];
		
		for(int loop=0; loop<5 ; loop++) {
			runnable[loop] = new RunnableSample();
			thread[loop] = new ThreadSample();
			
			new Thread(runnable[loop]).start();
			thread[loop].start();
		}
		System.out.println("RunThreads.runBasic2() method is dended.");
	}
	
	*/
	public static void main(String[] args) {
		RunThreads threads = new RunThreads();
		threads.runBasic();
	}
	
	
}
