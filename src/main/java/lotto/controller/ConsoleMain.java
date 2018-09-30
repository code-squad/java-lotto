package lotto.controller;

import lotto.service.LottoGames;
import lotto.view.ResultView;
import lotto.view.InputView;

import java.util.List;

import static lotto.service.LottoGames.LOTTO_PRICE_PER_TICKET;

public class ConsoleMain {

    public static void main(String[] args) {
        LottoGames lottoGames = getInputAndPlayGame();
        ResultView.printHavingLotto(lottoGames);

        setWinNumbers(lottoGames);

        int awardAmt = lottoGames.getAwardAmt();

        ResultView.printWinResult(lottoGames);

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

    public static void setWinNumbers(LottoGames lottoGames){
        try{
            List<String> winNumbers = InputView.getWinNumbers();
            lottoGames.setWinLotto(winNumbers);
        }catch (IllegalArgumentException e){
            System.out.println("ERROR : " + e.getMessage());
            setWinNumbers(lottoGames);
        }

    }

 }
