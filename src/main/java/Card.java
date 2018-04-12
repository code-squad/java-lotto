import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class Card {
    private List<Integer> numbers;
    public Card(List<Integer> sixNumbers) {
        this.numbers = sixNumbers;
//        pickSixNumbers(shuffleCardNumbers(createLottoValidNumbers()));
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }
    public int numMatchLuckNumber(List<Integer> luckyNumbers){
        int sum = 0;
        for (Integer luckyNumber : luckyNumbers){
            if(this.getNumbers().contains(luckyNumber)){
                sum++;
            }
        }

        //맵이나 튜플을 보내야하지 않을까?
        return sum;
    }

//    public isContain(int luckyNumber){
//        for (Integer n : this.getNumbers()){
//            n
//        }
//    }
}
