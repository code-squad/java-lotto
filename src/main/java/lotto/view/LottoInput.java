package lotto.view;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoInput {

    public String input() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int startLotto() {
        String times = input();
        return Integer.valueOf(times);
    }

    public int getManualTimes() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        try {
            return Integer.valueOf(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("숫자만 입력해 주세요");
            return -1;
        }
    }

    public List<Lotto> getManualLottoNumbers(int manuallyTimes) {

        if (manuallyTimes == -1) throw new IllegalArgumentException();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        List<String[]> inputValues = IntStream.range(0, manuallyTimes)
                .mapToObj(count -> scanner.nextLine())
                .map(input -> input.replaceAll(" ", "").split(","))
                .collect(toList());

        List<Lotto> lottos = null;

        lottos = inputValues.stream()
                .map(inputs -> Arrays.stream(inputs).map(Integer::valueOf).collect(toList()))
                .map(lotto -> new Lotto(lotto))
                .collect(toList());

        return lottos;
    }

    public String[] inputLastWeekNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input.replaceAll(" ", "").split(",");
    }

    public int inputBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return Integer.valueOf(scanner.nextLine());
    }

}
