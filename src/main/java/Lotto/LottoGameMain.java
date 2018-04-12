package Lotto;

public class LottoGameMain {
    public static void main(String[] args) {
        int money = InputLottoView.inputMoney();

        LottoGame lottoGame = new LottoGame();
        lottoGame.setCount(money);
        int count = lottoGame.getCount();

        Lotto lotto = new Lotto();
        lotto.setMoney(money);

        OutputLottoView.numberOfLottoPurchase(count);

        for (int i = 0; i < count; i++) {
            Integer[] lottoNumber = lottoGame.lottoNumber();
            lotto.setLottoNumbers(lottoNumber);
            System.out.println(OutputLottoView.lottoNumberPrint(lottoNumber));
        }

        lotto.setWinnerNumber(InputLottoView.inputWinnerNumber());

        for (Integer[] lottoNumber : lotto.getLottoNumbers()) {
            lotto.setMatchCount(lottoGame.returnContainNumber(lotto.getWinnerNumber(), lottoNumber));
        }

        OutputLottoView.winStat(lotto);
    }
}
