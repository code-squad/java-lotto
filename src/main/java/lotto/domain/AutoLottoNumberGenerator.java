package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Moonchan on 2018. 1. 16..
 */
public class AutoLottoNumberGenerator implements LottoNumberGenerator {

    private static final List<Integer> AVAILABLE_LOTTO_NUMBERS;

    static {
        AVAILABLE_LOTTO_NUMBERS = new ArrayList<>();
        for (int i = 1; i <= LottoTicket.MAX_LOTTO_NUMBER; i++) {
            AVAILABLE_LOTTO_NUMBERS.add(i);
        }
    }

    @Override
    public List<Integer> generateNumbers() {
        Collections.shuffle(AVAILABLE_LOTTO_NUMBERS);
        return new ArrayList<>(AVAILABLE_LOTTO_NUMBERS.subList(0, LottoTicket.LOTTO_NUMBERS_SIZE));
    }

    @Override
    public LottoTicket.Source getSource() {
        return LottoTicket.Source.AUTO;
    }
}
