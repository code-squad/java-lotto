package lottoGame.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Lotto {

    ArrayList<Integer> lottoNums = new ArrayList<>();

    public Lotto(ArrayList<Integer> lottoNums) {
        this.lottoNums = lottoNums;
    }

    public ArrayList<Integer> getLottoNums() {
        return lottoNums;
    }

    public boolean isSameLottoNum(int expectedLottoNum) {
        int sameCnt = 0;

        for(int lottoNum : lottoNums) {
             if(expectedLottoNum == lottoNum) {
                 sameCnt++;
             }
        }
        return sameCnt == 1;
    }

    public boolean isContainLuckyNum(int lottoNum) {
        return lottoNums.contains(lottoNum);
    }

    public int getSameLuckNumCnt(int[] luckyNums) {
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
        return lottoNums.toString();
    }
}
