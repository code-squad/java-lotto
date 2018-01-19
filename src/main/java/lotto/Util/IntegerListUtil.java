package lotto.Util;

import javax.annotation.Nonnull;
import java.util.List;

public class IntegerListUtil {

    public static boolean hasDuplicate(@Nonnull List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    public static boolean inRangeAll(@Nonnull List<Integer> numbers, int minInclusive, int maxExclusive){
        return inRangeClosedAll(numbers, minInclusive, maxExclusive-1);
    }

    public static boolean inRangeClosedAll(@Nonnull List<Integer> numbers, int minInclusive, int maxExclusive) {
        if(minInclusive > maxExclusive)
            return false;
        return numbers.stream()
                .filter(i -> i >= minInclusive)
                .filter(i -> i <= maxExclusive)
                .count() == numbers.size();
    }
}
