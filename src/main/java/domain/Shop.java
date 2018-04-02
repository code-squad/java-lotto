package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.LottoUtils.getRandNumbers;
import static domain.LottoUtils.listToLottoNoGroup;

public class Shop {

    static Lotto sellTicket(LottoNoGroup lottoNoGroup) {
        return Lotto.of(lottoNoGroup);
    }

    public static List<Lotto> sellManualTickets(List<LottoNoGroup> lottoNoGroups) {
        List<Lotto> lottos = new ArrayList<>();
        for (LottoNoGroup lottoNoGroup: lottoNoGroups) {
            lottos.add(sellTicket(lottoNoGroup));
        }
        return lottos;
    }

    public static List<Lotto> sellAutoTickets(int numTickets) {
        return sellManualTickets(genRandomLists(numTickets));
    }

    private static List<LottoNoGroup> genRandomLists(int numTickets) {
        return IntStream.range(0, numTickets)
                .mapToObj(i -> listToLottoNoGroup(getRandNumbers()))
                .collect(Collectors.toList());
    }

}
