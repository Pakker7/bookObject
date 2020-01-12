package org.eternity.step05.movie.step05;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
    private DiscountConditionType type;

    private int sequence;

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public DiscountCondition(int sequence){
        this.type = DiscountConditionType.SEQUENCE;
        this.sequence = sequence;
    }

    public DiscountCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime){ // <--여기로 초기화 될때 15줄의 sequence는 초기화가 안됨
        this.type = DiscountConditionType.PERIOD;										// 따라서 초기화 시에 초기화 되는게 있고 안되는게 있다는 말임
        this.dayOfWeek= dayOfWeek;														// 따라서 이게 응집도가 낮은 클래스라는거임
        this.startTime = startTime;														// 응집도가 높은 클래스는 초기화 시에 한번에 다 된다고 함
        this.endTime = endTime;
    }

    public boolean isDiscountable(Screening screening) {
        if (type == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(screening);
        }

        return isSatisfiedBySequence(screening);
    }

    private boolean isSatisfiedByPeriod(Screening screening) {
        return screening.getWhenScreened().getDayOfWeek().equals(dayOfWeek) &&
                startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
    }

    private boolean isSatisfiedBySequence(Screening screening) {
        return sequence == screening.getSequence();
    }
}
