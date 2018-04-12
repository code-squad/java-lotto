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
    public int numMatchLuckNumber(List<Integer> luckyNumbers){
        int sum = 0;
        for (Integer luckyNumber : luckyNumbers){
            if(this.getNumbers().contains(luckyNumber)){
                sum++;
            }
        }
        return sum;
    }
}
