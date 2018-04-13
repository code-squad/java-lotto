package javaLotto;

import javaLotto.domain.*;
import javaLotto.view.InputView;
import javaLotto.view.ResultView;

public class ConsoleMain {
    public static void main(String[] args) throws Exception {

        /*
        * 리스트 외부 공개 시 Collections.unmodifiableList() 사용
        * GameResult클래스 getGrade 메소드가 너무 많은 일을 하고 있다. 메소드 구현 (Map초기화, result반복,데이터 업데이트)
        * Map<Rank, Integer> 로 카운트 변경하기.  Map<String,Integer> 로 변경
        * Rank 클래스 bonus 인스턴스 변수 제거
        * Result 클래스의 grade, winningMoney, bonus 인스턴스 변수 제거 인스턴스 변수 최소화
        * Result 클래스 getGrade rank.getCountOfMatch()와 같이 구현
        * winningNumber 사용자가 구매한 값을 lottoTicket객체로 전달
        * winningNumber New Result 구현 부분
        *               int matchCount = userLotto.matchCount(winningNumber);
                        boolean bonus = userLotto.matchBonus(bonusBall);
                        return new Result(Rank.valueOf(matchCount, bonus));
        * 유효성 체크 추가
        * 테스트 코드 추가
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
