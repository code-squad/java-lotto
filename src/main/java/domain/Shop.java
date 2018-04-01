package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Shop {

    public static List<Lotto> sellAutoTickets(int numTickets) {
        return IntStream.range(0, numTickets)
                .mapToObj(i -> Lotto.of(LottoUtils.getRandNumbers()))
                .collect(Collectors.toList());
    }

}
