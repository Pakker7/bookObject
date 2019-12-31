package org.eternity.movie.step01;



public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening); //screen이 할인이 가능한 경우 true / false
}
