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
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

    public int numMatchLuckNumber(Card luckyCard){
        int hit = 0;
        for (Integer luckyNumber : luckyCard.getNumbers()){
            hit += hasLottoNumber(luckyNumber);
        }
        return hit;
    }

    private int hasLottoNumber(Integer luckyNumber) {
        if(this.getNumbers().contains(luckyNumber)){
            return 1;
        }
        return 0;
    }
}
