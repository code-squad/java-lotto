package lotto.view;

import lotto.util.LottoUtils;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static lotto.util.LottoUtils.LOTTO_MAX_COUNT;

public class Input {
    private Scanner scanner;

    private Input(Object value) {
        if(value instanceof String) { scanner = new Scanner((String) value); }
        else if(value instanceof InputStream) { scanner = new Scanner((InputStream) value); }
    }

    public static Input init(Object value) {
        return new Input(value);
    }

    private boolean checkThousandUnit(int money) {
        return money % LottoUtils.THOUSAND == 0;
    }

    public int getMoney() {
        Output.print("구입금액을 입력해 주세요.");
        int money = scanner.nextInt();
        if(!checkThousandUnit(money)) { throw new IllegalArgumentException(); }

        return money;
    }

    public List<Integer> winNumbers() {
        Output.print("지난 주 당첨 번호를 입력해 주세요.");
        return IntStream.range(0, LOTTO_MAX_COUNT)
                .map(i -> Integer.parseInt(scanner.next().substring(0, 1)))
                .boxed()
                .collect(toList());
    }


}
