package org.eternity.movie.step01;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

import org.eternity.money.Money;
import org.eternity.movie.step01.pricing.AmountDiscountPolicy;
import org.eternity.movie.step01.pricing.PeriodCondition;
import org.eternity.movie.step01.pricing.SequenceCondition;

public class main {

	public static void main(String[] args) {
		Movie avatar = new Movie("아바타", 
								Duration.ofMinutes(120), 
								Money.wons(10000), 
								new AmountDiscountPolicy(Money.wons(11000),     //금액할인이 아닌 퍼센트 할인을 받으려면 new PercentDiscountPolicy로만 바꾸면된다...!!!
																				//상속, 인터페이스를 사용해 이렇게까지 구조를 짤 수 있다니 큰 그림이다.
														new SequenceCondition(1),
														new SequenceCondition(2),
														new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
														new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(12, 30), LocalTime.of(14, 00))));
		
		// 새로 알게된 점
		// 생성자 초기화 시에 무조건 파라미터를 입력하게 하면 필요한 값이 비게 넘어오는 상황을 방지할 수 있다.
		// 그리고 1 depth 만 생성자를 받게 하지 말고, 생성자 초기화 시에 받는 파라미터 자체도 또 초기화를 무조건 파라미터를 입력하게 만들 수도 있다. 위의 상황처럼

		//이를 통해 저자가 말하고 싶은건...
		// 코드의 의존성과 실행 시점의 의존성이 서로 다를 수 있고, 둘이 다르면 다를 수록 코드는 더욱 유연해지고 확장 가능해진다는 것 p.59에 나옴
		
		
		//나의 생각
		// 유연해지고 확장 가능해 진다 는 것 --> 이 것에 대한 
		// 코드의 의존성과 실행 시점의 의존성을 다르게 하려면, 상속 or interface를 
	}

}
