import static java.util.Objects.isNull;

public class Calculator {

    public static int add(String input) {
        if (isNull(input) || input.isEmpty()) {
            return 0;
        }

        Positive operands = parse(input);
        validateOperands(operands);

        return sum(operands);
    }

    private static Positive parse(String input) {
        if (input.startsWith("//"))
            return new CustomSpliter(input).split();

        return new DefaultSpliter(input).split();
    }

    private static int sum(Positive operands) {
        return operands.getSplit().stream().mapToInt(Integer::intValue).sum();
    }

    private static void validateOperands(Positive operands) {
        operands.getSplit().forEach(operand -> {
            if (operand < 0) {
                throw new RuntimeException();
            }
        });
    }
}
