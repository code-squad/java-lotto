import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private ArrayList<Integer> numbers = new ArrayList<>();
    private ArrayList<Integer> lotto = new ArrayList<>();
    static ArrayList<Integer> counts = new ArrayList<>();

    public Lotto() {
        for(int i = 1; i < 46; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        for(int i = 0; i < 6; i++) {
            lotto.add(numbers.get(i));
        }
    }

    public void printLotto() {
        for(int i = 0; i < lotto.size(); i++) {
            System.out.print(lotto.get(i) + " ");
        }
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
