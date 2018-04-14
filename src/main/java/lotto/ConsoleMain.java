package lotto;

import lotto.domain.GameResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketIssuer;
import lotto.domain.LottoTickets;
import lotto.domain.WinningTicket;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

import java.util.List;
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
        String[] selfSelectLottoNumbers = IntStream.range(0, selfSelectLottoCount)
                .mapToObj(i -> ConsoleInputView.getLottoNumbers()).toArray(String[]::new);
        List<LottoTicket> selfLottoTickets = LottoTicketIssuer.issue(selfSelectLottoNumbers);

        // 3. 구입 결과 출력
        int restMoney = pay - LottoTicketIssuer.getTicketPrice(selfSelectLottoCount);
        LottoTickets lottoTickets = new LottoTickets(selfLottoTickets, LottoTicketIssuer.issue(restMoney));
        ConsoleOutputView.getPayResult(lottoTickets);

        // 4. 당첨번호 입력
        String winningNumber = ConsoleInputView.getWinningNumbers();
        
        // 5. 보너스번호 입력
        int bonusNumber = ConsoleInputView.getBonusNumber();
        LottoTicket winningTicket = LottoTicketIssuer.issue(winningNumber);
        GameResult gameResult = new GameResult(lottoTickets, new WinningTicket(winningTicket, bonusNumber));

        // 6. 당첨통계 출력
        ConsoleOutputView.printResult(gameResult.getAnalyzeResult());
        ConsoleOutputView.printRateOfReturn(gameResult.getRateOfReturn());
    }
}
