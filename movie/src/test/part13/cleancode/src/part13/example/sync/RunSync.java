package part13.example.sync;

public class RunSync {

	public static void main(String[] args) {
		RunSync runSync = new RunSync();
		runSync.runCommonCalculate();
	}
	
	public void runCommonCalculate() {
		CommonCalculate calc = new CommonCalculate();
		ModifyAmountThread thread1 = new ModifyAmountThread(calc, true);
		ModifyAmountThread thread2 = new ModifyAmountThread(calc, true);
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join(); // thread 종료될때까지 기다림
			thread2.join();
		
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}
}
