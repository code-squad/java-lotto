package out;

import dto.LottoTickets;
import dto.WinningResult;

public class Out {

    public void printBuyConfirmMassage(LottoTickets tickets) {
        System.out.println(tickets.toString());
        System.out.println(tickets.getSize() + "개를 구매하셨습니다.");
    }

    public void printResultMassage(WinningResult result) {
        System.out.println("당첨 통계\n" + "---------");
        System.out.println(result.toString());
        System.out.println("총 수익률은 " + result.getWinningPercent() + "% 입니다.");
    }
}
