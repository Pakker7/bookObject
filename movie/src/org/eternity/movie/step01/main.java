package org.eternity.movie.step01;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

import org.eternity.money.Money;
import org.eternity.movie.step01.pricing.AmountDiscountPolicy;
import org.eternity.movie.step01.pricing.NoneDiscountPolicy;
import org.eternity.movie.step01.pricing.PeriodCondition;
import org.eternity.movie.step01.pricing.SequenceCondition;

public class main {

	public static void main(String[] args) {
		System.out.println("start");
		
		
		Movie avatar = new Movie("아바타", 
								Duration.ofMinutes(120), 
								Money.wons(10000), 
								new AmountDiscountPolicy(Money.wons(11000),     //금액할인이 아닌 퍼센트 할인을 받으려면 new PercentDiscountPolicy로만 바꾸면된다...!!!
																				//상속, 인터페이스를 사용해 이렇게까지 구조를 짤 수 있다니 큰 그림이다.
														new SequenceCondition(1),
														new SequenceCondition(2),
														new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
														new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(12, 30), LocalTime.of(14, 00))));
		
		
		System.out.println("end");
		
		
		// 새로 알게된 점
		// 생성자 초기화 시에 무조건 파라미터를 입력하게 하면 필요한 값이 비게 넘어오는 상황을 방지할 수 있다.
		// 그리고 1 depth 만 생성자를 받게 하지 말고, 생성자 초기화 시에 받는 파라미터 자체도 또 초기화를 무조건 파라미터를 입력하게 만들 수도 있다. 위의 상황처럼

		//이를 통해 저자가 말하고 싶은건...
		// 코드의 의존성과 실행 시점의 의존성이 서로 다를 수 있고, 둘이 다르면 다를 수록 코드는 더욱 유연해지고 확장 가능해진다는 것 p.59에 나옴
		
		
		//나의 생각
		// 유연해지고 확장 가능해 진다 는 것 --> 이 것에 대한 이유는 위(new AmountDiscountPolicy)에서 보면 DiscountCondition(interface)로 파라미터를 받으니까 할인조건 관련
		//								class를 아무리 추가해도 상관이 없음 따라서 유연, 확장 가능
		// 코드의 의존성과 실행 시점의 의존성을 다르게 하려면, 상속 or interface를 적극..활용해야 함.
		// 의존성이라는 것은 너무 중요함. 없으면 안된다는거니까 의존성이 낮을수록, 독립적일 수록 좋은 코드 
		
		
		// 다형성 ; 동일한 메세지를 전송하지만 실제로 어떤 메서드가 실행 될 것인지는 메세지를 수신하는 객체의 클래스가 무엇이냐에 따라 달라지는것
		// ex) Movie는 초기화 시에  DiscountPolicy라고 써있음, 원래 코드에는 근데, 실제로 실행되는건 AmountDiscountPolicy임
		// 보통 상속을 이용하면 다형성을 구현할 수 있지만 이외에도 많은 방법이 있다고함..! 
		
		
		
		
		
		
		//p. 67 만약 할인정책과 할인금액이 하나도 없는 것이 있다면 이건 어떻게 추가할 것인가?
		// 나같으면 분명 돈계산 부분(Movie 에 calculateMovieFee)에 if null이면 이거 추가할텐데
		// 이렇게 되면, 할인 정책이 없는 경우를 예외 케이스로 취급하여, 협력 방식이 무너진다.... 책임을 다른사람에게 넘기는것임
		// 따라서 차라리 class를 하나더 추가하는게 협력관계를 정확히 유지하는것임
		Movie starWars = new Movie("스타워즈", Duration.ofMinutes(210), Money.wons(10000), new NoneDiscountPolicy());
		// 중요한건 원본의 수정 없이, class하나 추가만으로 변경했다는것. 이게 유연한 설계
		// 결론.. 유연성이 필요한 곳에 추상화를 사용하기
		
		
	}

}
