package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Shop {

    public static List<Lotto> sellAutoTickets(int numTickets) {
        return sellManualTickets(genRandomLists(numTickets));
    }

    public static List<Lotto> sellManualTickets(List<List<Integer>> numbers) {
        return numbers.stream().map(Lotto::of)
                .collect(Collectors.toList());
    }

    public static List<List<Integer>> genRandomLists(int numTickets) {
        return IntStream.range(0, numTickets)
                .mapToObj(i -> LottoUtils.getRandNumbers())
                .collect(Collectors.toList());
    }

}
