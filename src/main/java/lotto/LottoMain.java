package lotto;

public class LottoMain {

    public static void main(String[] args) {
        InputUI inputUI = new InputUI();
        int amount = inputUI.inputAmount();
        LottoStore lottoStore = new LottoStore(amount);

        ResultUI resultUI = new ResultUI(lottoStore);
        resultUI.printCount();
        resultUI.printLottos();

        String winNumbers = inputUI.inputLastWinNumber();

        resultUI.setLottoResult(new LottoResult(winNumbers, lottoStore));
        resultUI.printStatistics();
        resultUI.printPercentage();
    }
}
