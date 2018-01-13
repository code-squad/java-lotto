package lotto;

import java.util.*;

public class LottoGenerator {
    private static final int LAST_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;

    private static Random random = new Random();
    private static List<Integer> NUMBERS;
    static {
        NUMBERS = new ArrayList<>();
        for (int i = 1; i <= LAST_NUMBER; i++) {
            NUMBERS.add(i);
        }
    }

    public static List<Integer> randomNumbers() {
        Collections.shuffle(NUMBERS);

        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() != NUMBER_COUNT) {
            int randomNumber = NUMBERS.get(random.nextInt(LAST_NUMBER));
            randomNumbers.add(randomNumber);
        }
        return new ArrayList<>(randomNumbers);
    }
}
