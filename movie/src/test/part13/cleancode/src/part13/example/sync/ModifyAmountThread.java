package part13.example.sync;

public class ModifyAmountThread extends Thread{
	
	private CommonCalculate calc;
	private Boolean addFlag;
	
	public ModifyAmountThread() {
	}
	
	public ModifyAmountThread(CommonCalculate calc, Boolean addFlag) {
		this.calc = calc;
		this.addFlag = addFlag;
	}
	
	@Override
	public void run() {
		
		for (int i = 0; i < 10000; i++) {
			if(addFlag) {
				calc.plus(1);
			} else {
				calc.minus(1);
			}
			
		}
	}
}
