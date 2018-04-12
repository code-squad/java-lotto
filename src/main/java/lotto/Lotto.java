package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Integer> lotto;

    public List<Integer> getLotto() {
        return lotto;
    }
    public Lotto(){
        List<Integer> candidateNumbers = new ArrayList<>();

        for(int i=0; i<45; i++){
            candidateNumbers.add(i+1);
        }

        Collections.shuffle(candidateNumbers);
        lotto = candidateNumbers.subList(0, 6);
        Collections.sort(lotto);
    }

    public Lotto(String lottoNumbers){
        List<Integer> winNumbers = new ArrayList<>();
        String[] winStringNumbers = lottoNumbers.split(",");
        if(winStringNumbers.length != 6){
            throw new IllegalArgumentException();
        }

        for(String winToken:winStringNumbers){
            winNumbers.add(Integer.parseInt(winToken.trim()));
        }

        for(int i=0; i<winNumbers.size()-1; i++) {
            if( winNumbers.subList(i+1, winNumbers.size() ).contains(winNumbers.get(i)) ) {
                throw new IllegalArgumentException();
            }
        }

        lotto = winNumbers;
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
