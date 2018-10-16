package com.zingoworks.lotto.view;

import com.zingoworks.lotto.domain.FullLotto;
import com.zingoworks.lotto.domain.LottoResults;
import org.junit.Test;

import static com.zingoworks.lotto.domain.Lotto.NEWLINE;
import static com.zingoworks.lotto.domain.LottoResults.*;
import static org.junit.Assert.*;

public class ResultViewTest {

//    @Test
//    public void 테스트_결과출력() {
//        int purchaseAmount = 5000;
//        String lastWinningNumbers = "1,2,3,4,5,6";
//
//        FullLotto fl = new FullLotto(purchaseAmount);
//        LottoResults lr = new LottoResults(fl, lastWinningNumbers);
//
//        System.out.println("당첨통계" + NEWLINE +
//                "---------" + NEWLINE +
//                3 + "개 일치 (" + PRIZE_FORTH + "원)- " + lr.getRanks().get("FORTH") + "개" + NEWLINE +
//                4 + "개 일치 (" + PRIZE_THIRD + "원)- " + lr.getRanks().get("THIRD") + "개" + NEWLINE +
//                5 + "개 일치 (" + PRIZE_SECOND + "원)- " + lr.getRanks().get("SECOND") + "개" + NEWLINE +
//                6 + "개 일치 (" + PRIZE_FIRST + "원)- " + lr.getRanks().get("FIRST") + "개" + NEWLINE +
//                "총 수익률은 " + 100 + "%입니다.");
//    }
}