package lotto;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        LottoGames lottoGames = null;
        long buyAmt  = 0;
        long manualCount = -1;
        while(true){
            try{
                buyAmt =  InputView.getInputPrice();
                //수동갯수 입력 받기
                manualCount = InputView.getManualCount();
                //수동입력 번호 받기
                String[] manualNumbers = InputView.getManualNumbers(manualCount);
                lottoGames = new LottoGames(buyAmt, manualNumbers);

            }catch (IllegalArgumentException e){
                System.out.println("ERROR : " + e.getMessage());
                continue;
            }
            break;
        }

        while(true) {
            try{
                List<String> winNumbers = InputView.getWinNumbers();
                lottoGames.setWinLotto(winNumbers);
            }catch (IllegalArgumentException e){

                System.out.println("ERROR : " + e.getMessage());
                continue;
            }
            break;
        }

        ResultView.printHavingLotto(lottoGames);
        ResultView.printWinResult(buyAmt, lottoGames.getRankMap());

    }

 }
