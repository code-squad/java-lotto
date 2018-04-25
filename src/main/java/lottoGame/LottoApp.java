package lottoGame;

import lottoGame.model.*;
import lottoGame.view.InputView;
import lottoGame.view.OutputView;
import java.util.List;

public class LottoApp {

    public static void main(String[] args) {
        int money = InputView.getInputMoney();
        List<Lotto> lottoGames = LottoMachine.createLottoGame(Money.getLottoCnt(money));
        OutputView.printLottoGameResult(lottoGames);

        String inputWinNums = InputView.getWinningNumberString();
        GameResult result = LottoApp.lottoGamesPlay(lottoGames, LottoApp.getWinningLottoValues(inputWinNums), money);
        OutputView.printLottoGameResult(result);
    }


    public static GameResult lottoGamesPlay(List<Lotto> lottoGames, List<LottoNumbers> winningLottoNums, int money) {
        for(int i = 0; i < lottoGames.size(); i++) {
            Lotto lotto = lottoGames.get(i);
            matchRank(getMatchCnt(lotto,winningLottoNums));
        }

        return getGameResult(money);
    }

    public static List<LottoNumbers> getWinningLottoValues(String winNums) {
        Lotto winningLotto = Lotto.ofComma(winNums);
        return winningLotto.getLottoNumbersToList();
    }

    private static void matchRank(int matchCnt) {
        for(Rank rank : Rank.values()) {
            if(rank.isMatch(matchCnt)) {
                break;
            }
        }
    }

    private static int getMatchCnt(Lotto lotto, List<LottoNumbers> winningLottoNums) {
        return (int)winningLottoNums.stream().filter(number -> lotto.isNumberMatch(number)).count();

    }

    private static GameResult getGameResult(int money) {
        GameResult result = new GameResult();
        for(Rank rank : Rank.values()) {
            result.resultStrings.add(rank.getMatchCnt()+"개 일치 (" + rank.getReward() + ") - " + rank.getCnt() + "개 일치");
            result.sumMoney += rank.getReward()*rank.getCnt();
        }
        result.profitMoney = Money.getLottoProfitPer(result.sumMoney, money);

        return result;
    }

}
