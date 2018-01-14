import java.util.Arrays;
import java.util.Random;

public class Lotto {
    private static Random random;
    private int[] numbers;

    private Lotto() {
        random = new Random();
        numbers = new int[LottoUtils.LOTTO_MAX_COUNT];
        generateRandomNumber();
    }

    public static Lotto generate() {
        return new Lotto();
    }

    private void generateRandomNumber() {
        numbers = Arrays.stream(numbers).map(i -> random.nextInt(LottoUtils.LOTTO_MAX_NUMBER)).sorted().toArray();
    }

    public int[] getNumbers() {
        return numbers;
    }
}
