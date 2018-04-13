package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateLottoNumber {

    public Lotto generateRandomNumber(){

        ArrayList<Integer> ranNumber = getNumberRange();

        Collections.shuffle(ranNumber);

        List<Integer> selectedNumbers = pickRandomNumber(ranNumber);

        Collections.sort(selectedNumbers, new Ascending());

        return new Lotto(selectedNumbers);
    }

    public List<Integer> pickRandomNumber(ArrayList<Integer> ranNumber) {
        List<Integer> selectedNumbers = new ArrayList<>();

        for (int k = 0; k <= 5; k++)
            selectedNumbers.add(ranNumber.get(k));

        return selectedNumbers;
    }

    public ArrayList<Integer> getNumberRange() {
        ArrayList<Integer> ranNumber = new ArrayList<>();

        for(int j = 1; j <= 45; j++)
            ranNumber.add(j);

        return ranNumber;
    }

}
