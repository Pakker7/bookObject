package org.eternity.movie.step01;

import org.eternity.money.Money;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening)); 
        //여기 calculateMovieFee들어가보면 구현이 안되어 있는데.. 어디로 어떻게 연결되는거지?
        //이게 Money초기화 할때 위에처럼 this.discountPolicy = discountPolicy; 넣어주니까 이게 가능한 거임
        //근데 만약 Movie 초기화 할때 abstract class인 DiscountPolicy로 해준다면..? 
        // --> 안됨. abstract class는 초기화가 안됨 근데 어떻게 하면 된다고 하는데 이해가 안감..
        
    }
    
}

