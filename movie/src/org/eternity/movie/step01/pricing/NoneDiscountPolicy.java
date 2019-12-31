package org.eternity.movie.step01.pricing;

import org.eternity.money.Money;
import org.eternity.movie.step01.DiscountPolicy;
import org.eternity.movie.step01.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
    
    // 사실 overrride 한 이거는 의미가 없음
    // 이유는 DiscountPolicy에 보면 이렇게 작성되 있음
/*    public Money calculateDiscountAmount(Screening screening) {
        for(DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }*/
    
    //DiscountCondition 값이 없으면, 어짜피 return은 Money.ZERO임....ㄷㄷ 
    // 그럼 어짜피 NoneDiscountPolicy이거가 DiscountPolicy랑 역할이 겹치는 부분이 있자나 
    // 이걸해결하려먼 트레이드 오프 해야함 interface를 하나 더 추가해야함..
    // 이게 복잡해 보일수도 있지만, 고민한다는 것에 의의를 두자
}
