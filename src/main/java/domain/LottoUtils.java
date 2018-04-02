package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoUtils {

    private static final int MIN_INCLUSIVE = 1;
    private static final int MAX_EXCLUSIVE = 46;
    public static final int TICKET_PRICE = 1000;

    public static List<Integer> getRandNumbers() {
        List<Integer> numbers = IntStream.range(MIN_INCLUSIVE, MAX_EXCLUSIVE).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }

    static int countSameRank(List<Rank> ranks, Rank rank) {
        return (int) ranks.stream().filter(factor -> factor == rank).count();
    }

    static List<Integer> rankToInt(List<Rank> ranks) {
        return Arrays.stream(Rank.values()).mapToInt(i -> countSameRank(ranks, i)).boxed().collect(Collectors.toList());
    }

    static int calcTotalEarnings(List<Integer> prizeStatistics) {
        int totalPrize = 0;
        for (int i = 0; i < prizeStatistics.size(); i++) {
            totalPrize += prizeStatistics.get(i) * Rank.values()[i].getWinningMoney();
        }
        return totalPrize;
    }

    static List<Integer> stringToIntList(String line) {
        String[] numbers = line.split(",");
        return Arrays.stream(numbers).map(String::trim).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }


    static LottoNoGroup listToLottoNoGroup(List<Integer> numbers) {
        return LottoNoGroup.of(numbers.stream().map(LottoNo::of).collect(Collectors.toList()));
    }

    public static LottoNoGroup inputParser(String line) {
        return listToLottoNoGroup(stringToIntList(line));
    }

}
