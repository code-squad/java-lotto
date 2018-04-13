package javaLotto.domain;

public class Grade {
    public static GameResult checkGrade(Lotto lottos, WinningNumber winningNumber) {
        return winningNumber.checkGrade(lottos);
    }
}
