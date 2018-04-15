package javaLotto.utils;

import javaLotto.domain.LottoNo;
import javaLotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class LottoNumberGenerator {
    public static LottoTicket makeLottoNumber() {
        List<LottoNo> lotto = new ArrayList<>(IntStream.rangeClosed(1,45).distinct().mapToObj(no -> LottoNo.of(no)).collect(toList()));
        Collections.shuffle(lotto);
        return new LottoTicket(lotto.stream().limit(6).collect(toSet()));
    }
}
