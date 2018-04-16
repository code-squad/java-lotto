package javaLotto.utils;

import javaLotto.domain.LottoNo;
import javaLotto.domain.LottoTicket;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class LottoNumberGenerator {
    public static LottoTicket makeLottoNumber() {
        List<LottoNo> lotto = new ArrayList<>(IntStream.rangeClosed(1,45).distinct()
                .mapToObj(no -> new LottoNo(no))
                .collect(toList()));
        Collections.shuffle(lotto);
        return new LottoTicket(lotto.stream().limit(6).collect(toSet()));
    }

    public static LottoTicket makeLottoNumberManual(String lottoNumberString) {
        String [] divideNumber = lottoNumberString.split(",");
        Set<LottoNo> lottos = new HashSet<>();
        for (String number : divideNumber){
            lottos.add(new LottoNo(number));
        }
        return new LottoTicket(lottos);
    }
}
