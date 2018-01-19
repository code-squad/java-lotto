package lotto.domain;

import java.util.List;

/**
 * Created by Moonchan on 2018. 1. 16..
 */
public interface LottoNumberGenerator {
    List<Integer> generateNumbers();
    LottoTicket.Source getSource();
}
