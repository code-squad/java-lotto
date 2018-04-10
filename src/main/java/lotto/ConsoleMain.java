package lotto;

import lotto.domain.GameResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketIssuer;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleMain {
    public static void main(String[] args) {
        // 1. 구입금액 입력
        int pay = ConsoleInputView.getPay();

        // 2. 구입 결과 출력
        List<LottoTicket> lottoTickets = LottoTicketIssuer.issue(pay);
        ConsoleInputView.getPayResult(lottoTickets);

        // 3. 당첨번호 입력
        String winningNumber = ConsoleInputView.getWinningNumbers();
        GameResult gameResult = new GameResult(lottoTickets, new LottoTicket(toList(winningNumber)));

        // 4. 당첨통계 출력
        ConsoleOutputView.printResult(gameResult.analyzeResult());
        ConsoleOutputView.printRateOfReturn(gameResult.getRateOfReturn());
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
