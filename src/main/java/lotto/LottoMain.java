package lotto;

public class LottoMain {

    public static void main(String[] args) {
        InputUI inputUI = new InputUI();
        int amount = inputUI.inputAmount();
        LottoStore lottoStore = new LottoStore(amount);

        ResultUI.printCount(lottoStore);
        ResultUI.printLottos(lottoStore);

        String winNumbers = inputUI.inputLastWinNumber();
        LottoResult lottoResult = new LottoResult(winNumbers, lottoStore);
        ResultUI.printStatistics(lottoResult);
        ResultUI.printPercentage(lottoResult);

    }
}
