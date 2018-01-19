package lotto.domain;

import lotto.Util.IntegerListUtil;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Moonchan on 2018. 1. 13..
 */
public class LottoTicket {

    public static final int TICKET_PRICE = 1000;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBERS_SIZE = 6;

    private List<Integer> numbers;

    public LottoTicket() {
        this(new AutoLottoNumberGenerator());
    }

    public LottoTicket(LottoNumberGenerator lottoNumberGenerator) {
        this(lottoNumberGenerator.generateNumbers());
    }

    private LottoTicket(List<Integer> numbers) {
        checkValid(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    public int countMatchNumber(List<Integer> numbers) {
        List<Integer> combined = new ArrayList<>();
        combined.addAll(this.numbers);
        combined.addAll(numbers);
        return LOTTO_NUMBERS_SIZE * 2 - (int)combined.stream().distinct().count();
    }

    public boolean contains(int num) {
        return numbers.contains(num);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void checkValid(@Nonnull List<Integer> numbers) {
        if(numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또번호는 " + LOTTO_NUMBERS_SIZE + "개의 숫자로 초기화해야합니다.");
        }
        if(IntegerListUtil.hasDuplicate(numbers)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
        if(!IntegerListUtil.inRangeClosedAll(numbers, 1, MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException("로또 번호의 범위는 1부터 " + MAX_LOTTO_NUMBER + "까지 입니다.");
        }
    }

    @Override
    public String toString() {
        return new StringBuilder().append("[")
                .append(String.join(", ", numbers.stream().map(v -> v.toString()).collect(Collectors.toList())))
                .append("]").toString();
    }
}
