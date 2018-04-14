package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Integer> lotto;
    private Rank rank;

    public Lotto(){}

    public Lotto(String lottoNumbers){
        List<Integer> newLotto = new ArrayList<>();
        String[] winStringNumbers = lottoNumbers.split(",");

        for(String winToken:winStringNumbers){
            newLotto.add(Integer.parseInt(winToken.trim()));
        }

        checkConstructorValidation(winStringNumbers, newLotto);
        lotto = newLotto;
    }

    private void checkConstructorValidation(String[] winStringNumbers, List<Integer> winNumbers) {
        if(winStringNumbers.length != 6){
            throw new IllegalArgumentException();
        }

        for(int i=0; i<winNumbers.size()-1; i++) {
            if( winNumbers.subList(i+1, winNumbers.size() ).contains(winNumbers.get(i)) ) {
                throw new IllegalArgumentException();
            }
        }


    }

    public List<Integer> getLotto() {
        List<Integer> unModifiableLotto = Collections.unmodifiableList(lotto);
        return unModifiableLotto;
    }

    public Rank getRank(){
        return rank;
    }

    public int getMatchCount(WinLotto winLotto){
        int winCount = 0;
        for(Integer winNumber:winLotto.getWinLotto().getLotto()) {
            if( lotto.contains(winNumber) ){
                winCount++;
            }
        }
        return winCount;
    }

    public void setRank(WinLotto winLotto){
        rank = Rank.valueOf(getMatchCount(winLotto), lotto.contains(winLotto.getBonusNumber()));
    }


}
