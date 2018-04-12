package lottoGame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Integer> lottoNumbers = new ArrayList<>();

    public Lotto(List<Integer> lottoNums) {
        this.lottoNumbers = lottoNums;
    }

    public List<Integer> getLottoNums() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public boolean isSameLottoNum(int expectedLottoNum) {
        int sameCnt = 0;

        for(int lottoNum : lottoNumbers) {
             if(expectedLottoNum == lottoNum) {
                 sameCnt++;
             }
        }
        return sameCnt == 1;
    }

    public boolean isContainLuckyNum(int lottoNum) {
        return lottoNumbers.contains(lottoNum);
    }

    public int getSameLuckNumCnt(List<Integer> luckyNums) {
        int cnt = 0;
        for(int luckyNum : luckyNums) {
            if(isContainLuckyNum(luckyNum)) {
                cnt++;
            }
        }
        return cnt;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
