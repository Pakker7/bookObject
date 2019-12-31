package org.eternity.movie.step02;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

import org.eternity.money.Money;
import org.eternity.movie.step02.Movie;
import org.eternity.movie.step02.pricing.AmountDiscountPolicy;
import org.eternity.movie.step02.pricing.PercentDiscountPolicy;
import org.eternity.movie.step02.pricing.PeriodCondition;
import org.eternity.movie.step02.pricing.SequenceCondition;

public class main {
	public static void main(String[] args) {
		
		//p.70  상속의 가치 : 부모클래스가 제공 하는 모든 인터페이스를 자식 클래스가 물려받을 수 있음, 메서드나 인스턴스 변수를 재사용하는 것 이 아님
		// 상속의 단점 
		// 1. 캡슐화 위반
		// 2. 설계가 유연하지 않음 --> 부모 클래스와 자식 클래스 사이의 관계를 컴파일 시점에 결정함.따라서 실행 시점에 객체이 종류를 변경하는것이 불가능....? 무슨말...
		// ex. 실행 시점에 금액할인 정책인 영화를 비율할인 정책으로 변경한다면?
		// 거의 모든 언어는 이미 생성된 객체의 클래스를 변경하는 기능을 지원 XXXX 따라서 abstract class로 만들었으면 AmountDiscountMovie인스턴스를 PercentDiscountMovie의 인스턴스로 변경 해야됨
		// 아래 이거를 interface로 만든다면? 한번 변경해 보겠음
		Movie avatar = new Movie("아바타", 
				Duration.ofMinutes(120), 
				Money.wons(10000), 
				new AmountDiscountPolicy(Money.wons(11000),     
										new SequenceCondition(1),
										new SequenceCondition(2),
										new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
										new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(12, 30), LocalTime.of(14, 00))));
	
		avatar.changeDiscountPolicy(new PercentDiscountPolicy(..어찌고저찌고));
	
		//합성
		// 합성은 상속보다는 부모클래스 자식클래스의 결합이 덜하다. 따라서 합성을 사용하시라
	
	}
	
	
}
