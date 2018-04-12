package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Integer> lotto;

    public Lotto(){}

    public Lotto(String lottoNumbers){
        List<Integer> winNumbers = new ArrayList<>();
        String[] winStringNumbers = lottoNumbers.split(",");

        for(String winToken:winStringNumbers){
            winNumbers.add(Integer.parseInt(winToken.trim()));
        }

        checkConstructorValidation(winStringNumbers, winNumbers);
        lotto = winNumbers;
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

    public int getMatchCount(Lotto param){
        int winCount = 0;
        for(Integer winNumber:param.getLotto()) {
            if( lotto.contains(winNumber) ){
                winCount++;
            }
        }
        return winCount;
    }


}
