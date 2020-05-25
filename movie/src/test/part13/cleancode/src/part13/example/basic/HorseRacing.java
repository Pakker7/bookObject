package part13.example.basic;

import java.util.Random;

public class HorseRacing extends Thread{
	private int horseTotalNum;
	
	public HorseRacing() {}
	
	public HorseRacing(int horseTotalNum) {
		this.horseTotalNum = horseTotalNum;
	}

	public void run() {
		racing(Integer.toString(horseTotalNum));
	}
	
	public void racing(String name) {
		 
		try {
			Random random = new Random();
			int sleepTime = random.nextInt(1000);
			
			sleep(sleepTime);
			System.out.println("[" + name + "] ¸» µµÂø!");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
