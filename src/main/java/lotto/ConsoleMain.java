package lotto;

public class ConsoleMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String inputPrice =  inputView.getInputPrice();
        LottoGames lottoGames = new LottoGames();
        lottoGames.buy(inputPrice);
        String winNumbers = inputView.getWinNumbers();
        lottoGames.setWinnerLotto(winNumbers);
        ResultView resultView = new ResultView();
        resultView.printHavingLotto(lottoGames);
        resultView.printWinResult(lottoGames.getHavingCount(), lottoGames.getWinnerMap(), lottoGames.getRewardMap());

    }

 }
