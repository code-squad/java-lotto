import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lotto;
    static ArrayList<Integer> counts = new ArrayList<>();
    ArrayList<Integer> numbers = makeNumbers();

    public Lotto() {
        Collections.shuffle(numbers);
        lotto = numbers.subList(0, 6);
    }

    public static ArrayList<Integer> makeNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 1; i < 46; i++)
            numbers.add(i);
        System.out.println("로또 새로생성");
        return numbers;
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
