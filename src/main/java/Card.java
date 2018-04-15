import java.util.Collections;
import java.util.List;

public class Card {
    private List<Integer> numbers;

    public Card(List<Integer> sixNumbers) {
        if (sixNumbers.size() != 6){
            throw new IllegalArgumentException("argument size is not equal to 6" + sixNumbers.size());
        }
        this.numbers = Collections.unmodifiableList(sixNumbers);
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
