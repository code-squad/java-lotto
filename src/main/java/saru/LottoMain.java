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
        Output output = new Output(LottoCalculator.of(lottoLines).makeResult(), buyNum);
        output.printStatus();
    }
}
