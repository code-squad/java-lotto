package lotto.view;

import java.util.*;
import java.util.stream.IntStream;

public class InputView implements View {

    public static int getAmount() throws IllegalArgumentException, NoSuchElementException, IllegalStateException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<String> getWinningNumber() throws IllegalArgumentException, NoSuchElementException, IllegalStateException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputNumberWithComma = scanner.next();

        String[] splitNumber = inputNumberWithComma.split(",");

        return Arrays.asList(splitNumber);
    }

    public static String getBonusNumber() throws IllegalArgumentException, NoSuchElementException, IllegalStateException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.next();
    }

    public static int getManualLottoCount() throws IllegalArgumentException, NoSuchElementException, IllegalStateException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<List<String>> getManualLotto(int count) throws IllegalArgumentException, NoSuchElementException, IllegalStateException {
        Scanner scanner = new Scanner(System.in);
        List<List<String>> inputManualLottos = new ArrayList<>();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        IntStream.range(0, count)
                .forEach(i -> {
                    if(scanner.hasNext()) {
                        String inputNumberWithComma = scanner.next();

                        String[] splitNumber = inputNumberWithComma.split(",");
                        inputManualLottos.add(Arrays.asList(splitNumber));
                    }
                });

        return inputManualLottos;
    }
}
