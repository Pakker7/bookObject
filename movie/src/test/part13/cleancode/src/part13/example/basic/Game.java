package part13.example.basic;

public class Game {
	
	public static void main(String[] args) {
		
		int horseTotalCnt = 10;
		
		System.out.println("총 [" +horseTotalCnt+"] 마리의 말이 출발합니다.");
		
		for (int horseNum = 1; horseNum <= horseTotalCnt; horseNum++) {
			HorseRacing horseRacing = new HorseRacing(horseNum);
			horseRacing.start();
		}
		
	}
}
