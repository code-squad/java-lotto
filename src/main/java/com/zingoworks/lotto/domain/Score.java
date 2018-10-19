package com.zingoworks.lotto.domain;

import java.util.Objects;

public class Score {
    private int countOfMatching;
    private boolean isBonusScore;

    Score(int countOfHit, boolean isBonusHit) {
        this.countOfMatching = countOfHit;
        this.isBonusScore = isBonusHit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return countOfMatching == score.countOfMatching &&
                isBonusScore == score.isBonusScore;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfMatching, isBonusScore);
    }
}
