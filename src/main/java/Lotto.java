import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lotto;
    static ArrayList<Integer> counts = new ArrayList<>();
    static List<Integer> numbers;

    static {
        numbers = init();
    }

    public Lotto() {
        Collections.shuffle(numbers);
        lotto = numbers.subList(0, 6);
    }

    public static List<Integer> init() {
        List<Integer> values = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            values.add(i);
        }
        System.out.println("호출");
        return values;
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
