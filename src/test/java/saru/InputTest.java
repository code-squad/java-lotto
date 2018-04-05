package saru;

import saru.domain.*;
import saru.view.*;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class InputTest {
    private static LottoMaker lottoMaker = LottoMaker.of();

    @Test
    public void 로또구매() {
        assertEquals(14, Input.buy(14000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또구매_가격예외_zero이하() {
        Input.buy(0);
    }

    @Test
    public void 수동구매() {
        int manualNum = 3;
        String[] manualNumbers = {
                "8, 21, 23, 41, 42, 43",
                "3, 5, 11, 16, 32, 38",
                "7, 11, 16, 35, 36, 44"
        };
        List<String> manualNumbersList = Arrays.asList(manualNumbers);

        List<LottoLine> manualLottoLinesCompare = new ArrayList<>();
        for (int i = 0; i < manualNum; i++) {
            manualLottoLinesCompare.add(lottoMaker.makeManualLottoLine(manualNumbersList.get(i)));
        }

        List<LottoLine> manualLottoLines = Input.manualBuy(manualNumbersList);

        assertEquals(manualLottoLinesCompare.toString(), manualLottoLines.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 수동구매_인자수_에러() {
        String manualNumber = "8, 21, 23, 41, 42";
        List<String> manualNumbersList = new ArrayList<>();
        manualNumbersList.add(manualNumber);

        Input.manualBuy(manualNumbersList);
    }
}
