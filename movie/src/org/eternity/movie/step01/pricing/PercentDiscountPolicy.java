package org.eternity.movie.step01.pricing;

import org.eternity.money.Money;
import org.eternity.movie.step01.DiscountCondition;
import org.eternity.movie.step01.DiscountPolicy;
import org.eternity.movie.step01.Screening;

/*
 * 퍼센트 금액 할인 정책
 * 
 * */
public class PercentDiscountPolicy extends DiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
