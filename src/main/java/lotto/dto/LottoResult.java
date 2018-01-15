package lotto.dto;

//TODO: Map을 여기다 넣어놓기
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
