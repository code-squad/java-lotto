package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public static final int COUNT_OF_SELECT_LOTTO = 6;
    private static List<LottoNumber> lottoNumbers;
    public static Map<Rank, Integer> countOfMatch;

    private Money money;

    static {
         List<Integer> numbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
         lottoNumbers = numbers.stream()
                               .map(LottoNumber::of)
                               .collect(Collectors.toList());
         countOfMatch = new HashMap<Rank, Integer>();
    }

    public LottoMachine(long money) {
        this.money = Money.of(money);
    }

    public static Lotto getLottoNumber() {
        return createLottoNumbers();
    }

    private static Lotto createLottoNumbers() {
        List<LottoNumber> result = new ArrayList<>();
        Collections.shuffle(lottoNumbers);
        for (int index = 0; index < COUNT_OF_SELECT_LOTTO; index++) {
            result.add(lottoNumbers.get(index));
        }
        Collections.sort(result);
        return new Lotto(result);
    }

    public GameResult calculate(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Rank rank : Rank.values()) {
            countOfMatch.put(rank, Math.toIntExact(lottos.stream()
                  .filter(lotto -> lotto.match(winningLotto).equals(rank))
                  .count()));
        }
        return new GameResult(countOfMatch, getRateOfInvestment(countOfMatch));
    }

    double getRateOfInvestment(Map<Rank, Integer> winPrice) {
        int price = 0;
        for (Rank rank : winPrice.keySet()) {
            price += winPrice.get(rank) * rank.getMoney();
        }
        return Money.getRateOfInvestment(price);
    }
}
