import java.util.ArrayList;
import java.util.Collections;

public class Lotto {
    private ArrayList<Integer> numbers;
    private ArrayList<Integer> lotto;

    public Lotto() {
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> lotto = new ArrayList<>();
        for(int i = 0; i < 46; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        for(int i = 0; i < 6; i++) {
            lotto.add(numbers.get(i));
        }
    }

    public ArrayList<Integer> makeLotto(ArrayList<Integer> lottoNumbers) {
        ArrayList<Integer> lotto = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            lotto.add(lottoNumbers.get(i));
        }
        return lotto;
    }

    public void printLotto() {
        for(int i = 0; i < lotto.size(); i++) {
            System.out.print(lotto.get(i) + " ");
        }
    }
}
