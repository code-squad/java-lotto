package lotto;

import lotto.domain.LottoConstants;

import java.util.*;

public class LottoGenerator {
    private static Random random = new Random();
    private static List<Integer> NUMBERS;
    static {
        NUMBERS = new ArrayList<>();
        for (int i = LottoConstants.FIRST_NUMBER; i <= LottoConstants.LAST_NUMBER; i++) {
            NUMBERS.add(i);
        }
    }

    public static List<Integer> randomNumbers() {
        Collections.shuffle(NUMBERS);

        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() != LottoConstants.NUMBER_COUNT) {
            int randomNumber = NUMBERS.get(random.nextInt(LottoConstants.LAST_NUMBER));
            randomNumbers.add(randomNumber);
        }
        return new ArrayList<>(randomNumbers);
    }
}
