package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateLottoNumber {

    public static List<Lotto> generateRandomNumber(int times) {

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < times; i++) {
            try {
                List<Integer> ranNumber = getNumberRange();

                Collections.shuffle(ranNumber);

                List<Integer> selectedNumbers = pickRandomNumber(ranNumber);

                Collections.sort(selectedNumbers, new Ascending());

                lottos.add(new Lotto(selectedNumbers));
            } catch (IllegalArgumentException e) {
                return null;
            }
        }

        return lottos;
    }

    private static List<Integer> pickRandomNumber(List<Integer> ranNumber) {
        List<Integer> selectedNumbers = new ArrayList<>();

        for (int k = 0; k <= 5; k++)
            selectedNumbers.add(ranNumber.get(k));

        return selectedNumbers;
    }

    public static List<Integer> getNumberRange() {
        List<Integer> ranNumber = new ArrayList<>();

        for(int j = 1; j <= 45; j++)
            ranNumber.add(j);

        return ranNumber;
    }

}
