package lotto;

import java.util.*;

/**
 * Created by Joeylee on 2018-01-13.
 */
public class LottoMachine {

    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_MAX_NUM = 45;
    private List<Integer> bagicNumbers;
    private List<Lotto> lottos;

    public LottoMachine() {
        this.bagicNumbers = createLottoBasicNumbers();
    }

    private List<Integer> createLottoBasicNumbers() {
        List<Integer> numbers = new ArrayList<>(LOTTO_MAX_NUM);
        for (int i = 1; i <= LOTTO_MAX_NUM; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    public List<Lotto> createRandomLotto(int count) {
        lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(getRandomNumbers()));
        }
        return this.lottos;
    }

    public List<Integer> getRandomNumbers() {
        return subListNums(shuffleNums(createLottoBasicNumbers()));
    }

    private List<Integer> subListNums(List<Integer> nums) {
        nums = nums.subList(0, 6);
        Collections.sort(nums);
        return nums;
    }
    private List<Integer> shuffleNums(List<Integer> nums) {
        Collections.shuffle(nums);
        return nums;
    }

    public int countForPrice(int money) {
        return money / LOTTO_PRICE;
    }

    public void buyLottos(int count) {
        createRandomLotto(count);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Result makeResult(Lotto matchingLotto) {
        Result result = new Result();
        for (Lotto lotto : lottos) {
            result.increaseCount(lotto.countMatchingAnswer(matchingLotto));
        }

        return result;
    }
}
