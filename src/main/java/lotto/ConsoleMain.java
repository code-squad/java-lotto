package lotto;

import lotto.domain.GameResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketIssuer;
import lotto.domain.LottoTickets;
import lotto.domain.WinningTicket;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsoleMain {
    public static void main(String[] args) {
        // 1. 구입금액 입력
        int pay = ConsoleInputView.getPay();
        int purchasableTicketCount = LottoTicketIssuer.getPurchasableTicketCount(pay);

        // 2. 수동 로또 구매
        int selfSelectLottoCount = ConsoleInputView.getSelfSelectLottoCount();
        if (selfSelectLottoCount > purchasableTicketCount) {
            throw new IllegalArgumentException("구매 가능한 로또 수를 초과했습니다.");
        }

        ConsoleInputView.printInputSelfNumbersMessage();
        List<LottoTicket> selfLottoTickets = IntStream.range(0, selfSelectLottoCount)
                .mapToObj(i -> LottoTicketIssuer.issue(toList(ConsoleInputView.getLottoNumbers())))
                .collect(Collectors.toList());

        // 3. 구입 결과 출력
        int restMoney = pay - LottoTicketIssuer.getTicketPrice(selfSelectLottoCount);
        LottoTickets lottoTickets = new LottoTickets(selfLottoTickets, LottoTicketIssuer.issue(restMoney));
        ConsoleOutputView.getPayResult(lottoTickets);

        // 4. 당첨번호 입력
        String winningNumber = ConsoleInputView.getWinningNumbers();
        
        // 5. 보너스번호 입력
        int bonusNumber = ConsoleInputView.getBonusNumber();
        GameResult gameResult = new GameResult(lottoTickets, new WinningTicket(toList(winningNumber), bonusNumber));

        // 6. 당첨통계 출력
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
