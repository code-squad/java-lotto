import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lotto;
    static ArrayList<Integer> counts = new ArrayList<>();
    List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45);

    public Lotto() {
        Collections.shuffle(numbers);
        lotto = numbers.subList(0, 6);
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public ArrayList<Integer> checkNumber(List<String> rightNum) {
        int count = 0;
        for(int i = 0; i < rightNum.size(); i++) {
            if(lotto.contains(Integer.parseInt(rightNum.get(i))))
                count++;
        }
        counts.add(count);
        return counts;
    }
}
