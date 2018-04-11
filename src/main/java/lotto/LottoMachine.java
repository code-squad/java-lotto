package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public static final int COUNT_OF_SELECT_LOTTO = 6;
    public static final int MIN_COUNT_WIN_LOTTO = 3;
    public static final int LOTTO_PRICE = 1000;
    private static List<Integer> number;
    public static Map<Integer, Integer> winPrice;

    static {
         number = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
         winPrice = new HashMap<Integer, Integer>();
         winPrice.put(3, 5000);
         winPrice.put(4, 50000);
         winPrice.put(5, 1500000);
         winPrice.put(6, 2000000000);
    }

    public int getCountOfLotto(int money) {
        if (money < 0) {
            throw new IllegalArgumentException();
        }
        return money / LOTTO_PRICE;
    }

    public static List<Integer> getLottoNumber() {
        return createLottoNumbers();
    }

    private static List<Integer> createLottoNumbers() {
        List<Integer> result = new ArrayList<>();
        Collections.shuffle(number);
        for (int index = 0; index < COUNT_OF_SELECT_LOTTO; index++) {
            result.add(number.get(index));
        }
        Collections.sort(result);
        return result;
    }

    public int[] getMatchCounts(List<Integer>[] lottos, List<Integer> winLotto) {
        int[] matchCount = new int[7];
        for (int index = 0; index < lottos.length; index++) {
            matchCount[getMatchCount(lottos[index], winLotto)]++;
        }
        return matchCount;
    }

    private int getMatchCount(List<Integer> myLotto, List<Integer> winLotto) {
        Set<Integer> intersect = new HashSet<Integer>(myLotto);
        intersect.retainAll(winLotto);
        return intersect.size();
    }

    public double getRateOfInvestment(int money, int[] matchCount) {
        int price = 0;
        for (int index = MIN_COUNT_WIN_LOTTO; index <= COUNT_OF_SELECT_LOTTO; index++) {
            price += matchCount[index] * winPrice.get(index);
        }
        return (double) price / money * 100;
    }
}
