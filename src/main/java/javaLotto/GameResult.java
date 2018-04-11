package javaLotto;

import javaLotto.domain.Grade;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private List<Integer> result = new ArrayList<>();

    public GameResult(List<Integer> result) {
        this.result = result;
    }

    public List<Integer> getResult() {
        return result;
    }

    public int match(int checkGrade) {
        return Grade.returnGrade(result, checkGrade);
    }

    public double returnPercent(int inputPrice) {
        return Grade.returnPercent(result, inputPrice);
    }
}
