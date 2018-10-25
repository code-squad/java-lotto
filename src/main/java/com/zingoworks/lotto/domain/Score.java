//package com.zingoworks.lotto.domain;
//
//import java.util.Objects;
//
//public class Score {
//    private int countOfHit;
//    private boolean isBonusHit;
//
//    Score(int countOfHit, boolean isBonusHit) {
//        this.countOfHit = countOfHit;
//        this.isBonusHit = isBonusHit;
//    }
//
//    public int getCountOfHit() {
//        return countOfHit;
//    }
//
//    public boolean isBonusHit() {
//        return isBonusHit;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Score score = (Score) o;
//        return countOfHit == score.countOfHit &&
//                isBonusHit == score.isBonusHit;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(countOfHit, isBonusHit);
//    }
//}
