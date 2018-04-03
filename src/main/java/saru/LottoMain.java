package saru;

import saru.view.*;
import saru.domain.*;

import java.util.*;

public class LottoMain {
    public static void main(String[] args) {
        int buyNum = Input.promptBuy();
        LottoMaker lottoMaker = LottoMaker.of();

        //-----------------------------------------------------
        // TODO - 수동구매 갯수 입력, 수동구매 번호 입력
        int manualNum = 3;

        // TODO 3입력하면 3번 입력 받아서 LottoLine 배열로 반환
        String[] manualNumbers = {
                "8, 21, 23, 41, 42, 43",
                "3, 5, 11, 16, 32, 38",
                "7, 11, 16, 35, 36, 44"
        };

        // TODO 테스트
        List<LottoLine> manualLottoLines = new ArrayList<>();
        for (int i = 0; i < manualNum; i++) {
            manualLottoLines.add(LottoLine.of(lottoMaker.makeManualLottoNums(manualNumbers[i])));
        }
        //-----------------------------------------------------

        List<LottoLine> lottoLines = lottoMaker.makeAutoLottoLines(buyNum);
        Output.printCreatedNum(manualLottoLines, lottoLines);

        String hitNumber = Input.promptHitNumber();
        int bonusNumber = Input.promptBonusNumber();

        LottoCalculator lottoCalculator = LottoCalculator.of(manualLottoLines, lottoLines);
        Output output = new Output(lottoCalculator.makeResult(buyNum, hitNumber, bonusNumber));
        output.printStatus();
    }
}
