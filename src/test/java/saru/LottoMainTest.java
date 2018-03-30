package saru;

import saru.domain.*;
import saru.view.*;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import org.junit.Test;

public class LottoMainTest {
    @Test
    public void 로또번호() {
        assertEquals(10, LottoNumber.of(10).getNumber());
    }

    @Test
    public void 번호자동생성() {
        List<LottoNumber> lottoNumberList = LottoMaker.of().makeLottoList();
        assertEquals(6, lottoNumberList.size());
    }

    @Test
    public void 로또자동생성여러개() {
        // TODO 로또넘버리스트 생성
        LottoMaker lottoMaker = LottoMaker.of();
        List<LottoNumberList> lottoNumberLists = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            lottoNumberLists.add(new LottoNumberList(lottoMaker.makeLottoList()));
        }

        assertEquals(10, lottoNumberLists.size());
        //System.out.println(lottoNumberLists);
    }

    @Test
    public void 당첨번호갯수() {
        String resultStr = "1, 2, 3, 4, 5, 6";

        String compareStr = "1, 2, 3, 8, 9, 10";
        List<LottoNumber> inputNumberList = Input.makeManualLottoNumbers(compareStr);

        LottoMatcher lottoMatcher = LottoMatcher.of(Input.makeManualLottoNumbers(resultStr));
        int matchNum = lottoMatcher.match(inputNumberList);

        assertEquals(3, matchNum);
    }

    @Test
    public void 당첨결과확인() {
        String resultStr = "1, 2, 3, 4, 5, 6";

        String compareStr = "3, 4, 5, 6, 9, 10";
        List<LottoNumber> inputNumberList = Input.makeManualLottoNumbers(compareStr);

        String compareStr2 = "3, 4, 5, 6, 9, 10";
        List<LottoNumber> inputNumberList2 = Input.makeManualLottoNumbers(compareStr2);

        String compareStr3 = "3, 4, 5, 6, 1, 2";
        List<LottoNumber> inputNumberList3 = Input.makeManualLottoNumbers(compareStr3);

        List<LottoNumberList> lottoNumberLists = new ArrayList<>();

        lottoNumberLists.add(new LottoNumberList(inputNumberList));
        lottoNumberLists.add(new LottoNumberList(inputNumberList2));
        lottoNumberLists.add(new LottoNumberList(inputNumberList3));

        LottoMatcher lottoMatcher = LottoMatcher.of(Input.makeManualLottoNumbers(resultStr));
        Result result = Result.of();

        result.increaseHit(lottoMatcher.match(inputNumberList));
        result.increaseHit(lottoMatcher.match(inputNumberList2));
        result.increaseHit(lottoMatcher.match(inputNumberList3));

        assertEquals(2, result.getFourHit());
        assertEquals(1, result.getSixHit());
        //System.out.println(result);
    }
}