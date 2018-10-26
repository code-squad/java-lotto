//package com.zingoworks.lotto.domain;
//
//import static com.zingoworks.lotto.domain.Lotto.MAXIMUM_RANGE;
//import static com.zingoworks.lotto.domain.Lotto.MINIMUM_RANGE;
//
//public class No {
//
//
//    private int number;
//
//    private No(int number) {
//        checkValidRange(number);
//        this.number = number;
//    }
//
//    static No of(int x) {
//        return new No(x);
//    }
//
//    private void checkValidRange(int number) {
//        if(number < MINIMUM_RANGE || number > MAXIMUM_RANGE) {
//            throw new IllegalArgumentException("1~45까지의 숫자 중 선택 가능합니다.");
//        }
//    }
//}
