package calculator;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static java.util.Objects.isNull;

public class Calculator {

    private static List<Spliter> spliters;
    static {
        spliters = Lists.newArrayList(
                new DefaultSpliter(),
                new CustomSpliter()
        );
    }

    public static int add(String input) {
        if (isNull(input) || input.isEmpty()) {
            return 0;
        }

        if (StringUtils.isNumeric(input)) {
            return Integer.parseInt(input);
        }

        return sum(parse(input));
    }

    private static List<Positive> parse(String input) {
        return getTargetSpliter(input).split(input);
    }

    private static Spliter getTargetSpliter(String input) {
        return Calculator.spliters.stream().filter(spliter -> spliter.isSpliterable(input)).findFirst().orElseThrow(IllegalArgumentException::new);
    }
    private static int sum(List<Positive> operands) {
        return operands.stream().mapToInt(Positive::getNumber).sum();
    }
}
