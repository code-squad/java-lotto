package domain;

import java.util.List;

public class UserLotto extends Lotto{
    public UserLotto(List<Integer> numbers) {
        super(numbers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int number : numbers) {
            sb.append(number);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
