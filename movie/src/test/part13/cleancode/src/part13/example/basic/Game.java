package part13.example.basic;

public class Game {
	
	public static void main(String[] args) {
		
		int horseTotalCnt = 10;
		
		System.out.println("�� [" +horseTotalCnt+"] ������ ���� ����մϴ�.");
		
		for (int horseNum = 1; horseNum <= horseTotalCnt; horseNum++) {
			HorseRacing horseRacing = new HorseRacing(horseNum);
			horseRacing.start();
		}
		
	}
}
