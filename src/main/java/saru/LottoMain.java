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

        List<LottoNumberList> lottoNumberLists = makeLottoNumber(buyNum);

        Output.printCreatedNum(lottoNumberLists);

        Result result = makeResult(lottoNumberLists);

        Output output = new Output(result, buyNum);
        output.printStatus();
    }

    private static Result makeResult(List<LottoNumberList> lottoNumberLists) {
        Result result = Result.of();
        List<LottoNumber> hitNumberList = Input.makeManualLottoNumbers(Input.promptHitNumber());
        LottoMatcher lottoMatcher = LottoMatcher.of(hitNumberList);

        for (LottoNumberList lottoNumberList : lottoNumberLists) {
            result.increaseHit(lottoMatcher.match(lottoNumberList.getNumbers()));
        }
        return result;
    }

    private static List<LottoNumberList> makeLottoNumber(int buyNum) {
        LottoMaker lottoMaker = LottoMaker.of();
        List<LottoNumberList> lottoNumberLists = new ArrayList<>();

        for (int i = 0; i < buyNum; i++) {
            lottoNumberLists.add(new LottoNumberList(lottoMaker.makeLottoList()));
        }
        return lottoNumberLists;
    }
}
