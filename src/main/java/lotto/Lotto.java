package lotto;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<LottoNo> lotto;

    public Lotto(String paramLottoNumbers){
        List<LottoNo> newLotto = new ArrayList<>();
        String[] lottoNumbers = paramLottoNumbers.split(",");

        if(lottoNumbers.length != 6){
            throw new IllegalArgumentException();
        }

        for(String winToken:lottoNumbers){
            newLotto.add( new LottoNo(Integer.parseInt(winToken.trim()) ) );
        }

        checkConstructorValidation(lottoNumbers, newLotto);
        lotto = newLotto;
    }

    private int getLottoSingleNumber(String singleNumber) {
        if(singleNumber == null || singleNumber.isEmpty() || singleNumber.trim().isEmpty() || !StringUtils.isNumeric(singleNumber)){
            throw new IllegalArgumentException();
        }

        int lottoNumber = Integer.parseInt(singleNumber.trim());
        if(lottoNumber < 1 || lottoNumber > 45){
            throw new IllegalArgumentException();
        }
        return lottoNumber;
    }

    private void checkConstructorValidation(String[] lottoNumbers, List<LottoNo> winNumbers) {
        if(lottoNumbers.length != 6){
            throw new IllegalArgumentException();
        }

        for(int i=0; i<winNumbers.size()-1; i++) {
            if( winNumbers.subList(i+1, winNumbers.size() ).contains(winNumbers.get(i)) ) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<LottoNo> getLotto() {
        List<LottoNo> unModifiableLotto = Collections.unmodifiableList(lotto);
        return unModifiableLotto;
    }

    public int getMatchCount(WinLotto winLotto){
        int winCount = 0;

        for(LottoNo winNumber:winLotto.getWinLotto().getLotto()) {
            if( lotto.contains(winNumber) ){
                winCount++;
            }
        }
        return winCount;
    }


    public Rank calculateRank(WinLotto winLotto){
        return Rank.valueOf(getMatchCount(winLotto), lotto.contains(winLotto.getBonusNumber()));
    }


    public boolean contains(LottoNo number) {

        return lotto.contains(number);
    }

    @Override
    public String toString() {

        String[] lottoNumbers = new String[lotto.size()];

        for(int i=0; i<lotto.size(); i++){
            lottoNumbers[i] = new String(lotto.get(i).getLottoNo() + "");
        }

        return "[" + String.join(",", lottoNumbers) + "]";
    }
}
