package saru;

import saru.view.*;
import saru.domain.*;

import java.util.*;

public class LottoMain {
    private static LottoMaker lottoMaker = LottoMaker.of();

    public static void main(String[] args) {
        int buyNum = Input.promptBuy();
        List<LottoLine> lottoLines = lottoMaker.makeAutoLottoLines(buyNum);
        List<LottoLine> manualLottoLines = getLottoLines();

        Output.printCreatedNum(manualLottoLines, lottoLines);
        LottoCalculator lottoCalculator = LottoCalculator.of(LottoUtil.joinLottoLines(manualLottoLines, lottoLines));

        Output output = new Output(getResult(buyNum, lottoCalculator));
        output.printStatus();
    }

    private static Result getResult(int buyNum, LottoCalculator lottoCalculator) {
        String hitNumber = Input.promptHitNumber();
        int bonusNumber = Input.promptBonusNumber();

        Result result;
        try {
            result = lottoCalculator.makeResult(buyNum, hitNumber, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("다시 입력해라");
            return getResult(buyNum, lottoCalculator);
        }

        return result;
    }

    private static List<LottoLine> getLottoLines() {
        List<LottoLine> manualLottoLines = null;
        boolean isTrue = false;

        do {
            try {
                manualLottoLines = Input.manualBuy(Input.manualInputProc());
                isTrue = true;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        } while (!isTrue);

        return manualLottoLines;
    }
}
