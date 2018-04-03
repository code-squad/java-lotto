package saru;

import saru.view.*;
import saru.domain.*;

import java.util.*;

public class LottoMain {
    public static void main(String[] args) {
        int buyNum = Input.promptBuy();
        List<LottoLine> lottoLines = LottoMaker.of().makeLottoNumber(buyNum);
        Output.printCreatedNum(lottoLines);

        String hitNumber = Input.promptHitNumber();
        int bonusNumber = Input.promptBonusNumber();

        LottoCalculator lottoCalculator = LottoCalculator.of(lottoLines);
        Output output = new Output(lottoCalculator.makeResult(buyNum, hitNumber, bonusNumber));
        output.printStatus();
    }
}
