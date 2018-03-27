package domain;

import java.util.List;

public class UserLotto extends Lotto {
    public static final int LOTTO_NUM = 6;

    UserLotto(List<Integer> numbers) {
        super(numbers);
    }
}
