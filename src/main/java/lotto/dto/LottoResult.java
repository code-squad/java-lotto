package lotto.dto;

public class LottoResult {
    private int correctCount;

    public LottoResult(int correctCount) {
        this.correctCount = correctCount;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int sumCount() {
        return 1;
    }
}
