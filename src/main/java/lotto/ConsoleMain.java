package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoTicket;
import lotto.domain.PrizeDivision;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        
        // 1. 구입금액 입력
        ConsoleInputView.printBuyOrderMessage();
        int pay = scanner.nextInt();
        scanner.nextLine();

        // 2. 구입 결과 출력
        List<LottoTicket> lottoTickets = LottoGame.buyTicket(pay);
        ConsoleInputView.printOrderResult(lottoTickets);

        // 3. 당첨번호 입력
        ConsoleInputView.printWinningNumbersMessage();
        String winningNumber = scanner.nextLine();
        LottoTicket winningTicket = new LottoTicket(toList(winningNumber));

        // 4. 당첨통계 출력
        List<PrizeDivision> winningResults = LottoGame.getResult(winningTicket, lottoTickets);
        Map<PrizeDivision, Integer> result = LottoGame.analyzeResult(winningResults);
        ConsoleOutputView.printResult(result);
    }

    private static List<Integer> toList(String numbersText) {
        return Arrays.stream(parseInts(split(numbersText)))
                .boxed()
                .collect(Collectors.toList());
    }

    private static String[] split(String text) {
        return text.split(",");
    }

    private static int[] parseInts(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
