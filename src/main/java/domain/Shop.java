package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Shop {

    static Lotto sellTicket(List<Integer> numbers) {
        return Lotto.of(numbers);
    }

    public static List<Lotto> sellManualTickets(List<List<Integer>> manualInput) {
        List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> numbers : manualInput) {
            lottos.add(sellTicket(numbers));
        }
        return lottos;
    }

    public static List<Lotto> sellAutoTickets(int numTickets) {
        return sellManualTickets(genRandomLists(numTickets));
    }

    private static List<List<Integer>> genRandomLists(int numTickets) {
        return IntStream.range(0, numTickets)
                .mapToObj(i -> LottoUtils.getRandNumbers())
                .collect(Collectors.toList());
    }

}
