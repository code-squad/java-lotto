package lotto.domain;

import lotto.util.LottoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoVendor {

    private final static int LOTTO_PRICE = 1000;
    private final static String PARSING_SYMBOL = ",";
    private final static String INIT_JACKPOT_NUMBER = "1,2,3,4,5,6";
    private static LottoVendor instance;

    private Lotto lastJackpotLotto;

    private LottoVendor() {
        setLastJackpotLotto(INIT_JACKPOT_NUMBER);
    }

    public static LottoVendor getInstance() {
        if ( instance == null ) {
            instance = new LottoVendor();
        }
        return instance;
    }

    public int parseMoney(String money) {
        if (!isNumeric(money)) new IllegalArgumentException();
        return Integer.parseInt(money);
    }

    private boolean isNumeric(String money) {
        return money.matches("^[0-9]*$");
    }

    public int unitPerLotto(Integer money) {
        if (money < LOTTO_PRICE) new IllegalArgumentException();
        return money/LOTTO_PRICE;
    }

    public List<Lotto> buy(String money) {
        return order(unitPerLotto(parseMoney(money)));
    }

    private List<Lotto> order(Integer count) {
        ArrayList<Lotto> lottery = new ArrayList<>();
        for (Integer i = 0; i < count; i++) {
            lottery.add(new Lotto());
        }
        return lottery;
    }

    public void setLastJackpotLotto(String numbers) {
        if (isBlank(numbers)) throw new IllegalArgumentException();
        String[] split = numbers.split(PARSING_SYMBOL);
        if (!isNumeric(split)) throw new IllegalArgumentException();
        this.lastJackpotLotto = LottoUtil.parseLotto(toIntegerList(split));
    }

    private List<Integer> toIntegerList(String[] numbers) {
        return Stream.of(numbers).map(Integer::parseInt).collect(Collectors.toList());
    }

    private boolean isBlank(String numbers) {
        return numbers == null || numbers.isEmpty();
    }

    private boolean isNumeric(String[] split) {
        return Stream.of(split).allMatch(this::isNumeric);
    }

    public Lotto getLastJackpotLotto() {
        return lastJackpotLotto;
    }
}