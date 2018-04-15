package javaLotto;

import javaLotto.domain.*;
import javaLotto.view.InputView;
import javaLotto.view.ResultView;

public class ConsoleMain {
    public static void main(String[] args) throws Exception {

        /*
        * 2차 피드백
        * 불필요한  for문 삭제
        * Map<String,Integer> --> Map<Rank,Integer> 변경
        * Number 값 하나를 추상화한 LottoNo객체 추가 후 유효성 체크
        * 중복 방지를 위한 자료형 변경 List--> Set
        *
        * 기타 추가사항
        * LottoNumberGenerator 스트림으로 변경
        * */

        int price = Integer.parseInt(InputView.setPrice());
        Lotto lotto = JavaLotto.buyLotto(price);
        ResultView.buyLottoInfoPrint(lotto);

        String winningNumber = InputView.setWinningNumber();
        String bonusNumber = InputView.setBonusNumber();

        GameResult result = Grade.checkGrade(lotto, new WinningNumber(winningNumber, bonusNumber));
        ResultView.resultPrint(result, price);

    }
}
