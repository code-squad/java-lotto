package saru;

import saru.view.*;
import saru.domain.*;

import java.util.*;

public class LottoMain {
    public LottoMain() {
        // empty
    }

    public static void main(String[] args) {
        int buyNum = Input.promptBuy();
        List<LottoLine> lottoLines = LottoMaker.of().makeLottoNumber(buyNum);
        Output.printCreatedNum(lottoLines);

        // 당첨번호를 입력 받고 이어서 보너스 번호도 입력 받는다
        String hitNumber = Input.promptHitNumber();
        int bonusNumber = Input.promptBonusNumber();

        LottoCalculator lottoCalculator = LottoCalculator.of(lottoLines);

        // 결과를 만들때 당첨번호와 같이 보너스 번호를 보낸다.
        Output output = new Output(lottoCalculator.makeResult(hitNumber, bonusNumber), buyNum);
        output.printStatus();
    }
}
