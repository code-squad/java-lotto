package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static Lottos buyAutomatic(long ticketCounts) {
        Lottos lottos = new Lottos();
        for(int i=0; i<ticketCounts; i++){
            List<String> randomNumbers = generateRandomLottoNumbers();
            String numbers = String.join(", ", randomNumbers.toArray(new String[randomNumbers.size()]) );
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public static Lottos buyManually( String[] manualNumbers){
        Lottos lottos = new Lottos();
        for(String manualNumber : manualNumbers){
            lottos.add(new Lotto(manualNumber));
        }
        return lottos;
    }

    private static List<String> generateRandomLottoNumbers(){
        List<String> candidateNumbers = new ArrayList<>();
        List<String> lottoNumber;

        for(int i=0; i<45; i++){
            candidateNumbers.add(  (i+1) + "" );
        }

        Collections.shuffle(candidateNumbers);
        lottoNumber = candidateNumbers.subList(0, 6);
        Collections.sort(lottoNumber);
        return lottoNumber;
    }
}
