package lotto;

import java.util.List;

import static lotto.LottoGames.LOTTO_PRICE_PER_TICKET;

public class ConsoleMain {

    public static void main(String[] args) {
        LottoGames lottoGames = getInputAndPlayGame();

        ResultView.printHavingLotto(lottoGames);
        ResultView.printWinResult(lottoGames.getHavingCount() * LOTTO_PRICE_PER_TICKET , lottoGames.getRankMap());

    }

    public static LottoGames getInputAndPlayGame(){
        LottoGames lottoGames = null;
        long buyAmt  = 0;
        long manualCount = -1;

        try{
            buyAmt =  InputView.getInputPrice();
            //수동갯수 입력 받기
            manualCount = InputView.getManualCount();
            //수동입력 번호 받기
            String[] manualNumbers = InputView.getManualNumbers(manualCount);
            lottoGames = new LottoGames(buyAmt, manualNumbers);

        }catch (IllegalArgumentException e){
            System.out.println("ERROR : " + e.getMessage());
            getInputAndPlayGame();
        }

        return lottoGames;

    }

 }
