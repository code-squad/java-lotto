package lotto.view;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import lotto.domain.Lotto;
import lotto.util.LottoUtils;

import static java.util.stream.Collectors.toList;
import static lotto.domain.LottoMachine.makeCustomLottos;
import static lotto.util.LottoUtils.LOTTO_MAX_COUNT;
import static lotto.util.LottoUtils.REGEX;

public class Input {
    private static Scanner scanner;

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

    public Lotto winNumbers() {
        Output.print("지난 주 당첨 번호를 입력해 주세요.");
        return Lotto.newCustomLotto((getCommonLottoNumbers()));
    }

    public static int getBonusBall(Lotto winningLotto) {
        Output.print("보너스 볼을 입력해 주세요.");
        int bonusBall = scanner.nextInt();
        if(winningLotto.getNumbers().contains(bonusBall)) { throw new IllegalArgumentException("중복된 번호입니다."); }
        return bonusBall;
    }

    public int customLottoCount() {
        Output.print("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public List<Lotto> customLottoms(int customCount) {
        if(customCount == 0) return null;
        Output.print("수동으로 구매할 번호를 입력해 주세요.");
        return makeCustomLottos(customCount);
    }

    public static List<Integer> getCommonLottoNumbers() {
        return IntStream.range(0, LOTTO_MAX_COUNT)
                .map(i -> Integer.parseInt(scanner.next().replace(REGEX, "")))
                .boxed()
                .collect(toList());
    }

}
