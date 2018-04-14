package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<Integer> lotto;

    @Override
    public String toString() {
        String str = "";
        for(Integer integer : lotto){
            str += integer + ", ";
        }

        return "[" + str.substring(0, str.length()-2) + "]";


    }

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

    public int getMatchCount(WinLotto winLotto){
        int winCount = 0;

        for(Integer number : lotto){
            if( winLotto.contain(number) ) {
                winCount++;
            }
        }
        return winCount;
    }


    public Rank calculateRank(WinLotto winLotto){
        return Rank.valueOf(getMatchCount(winLotto), lotto.contains(winLotto.getBonusNumber()));
    }


    public boolean contains(Integer number) {
        return lotto.contains(number);
    }
}
