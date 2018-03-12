import java.util.ArrayList;
import java.util.Collections;

public class Lotto {
    private ArrayList<Integer> numbers;
    private ArrayList<Integer> lotto;

    public ArrayList<Integer> lottoNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 1; i < 46; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    public void shuffle(ArrayList<Integer> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
    }

    public ArrayList<Integer> makeLotto(ArrayList<Integer> lottoNumbers) {
        ArrayList<Integer> lotto = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            lotto.add(lottoNumbers.get(i));
        }
        return lotto;
    }

    public void printLotto(ArrayList<Integer> lotto) {
        for(int i = 0; i < lotto.size(); i++) {
            System.out.print(lotto.get(i) + " ");
        }
    }
}
