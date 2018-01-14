package lotto.view;

import lotto.util.LottoUtils;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

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
        int money = scanner.nextInt();
        if(!checkThousandUnit(money)) { throw new IllegalArgumentException(); }

        return money;
    }

    public List<Integer> winNumbers() {
        String[] stringWinNumbers = scanner.nextLine().split(LottoUtils.REGEX);
        return LottoUtils.convertStringToIntList(stringWinNumbers);
    }


}
