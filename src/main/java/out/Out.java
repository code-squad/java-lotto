package out;

import dto.LottoTickets;
import dto.WinningResult;

public class Out {

    public void printBuyConfirmMassage(LottoTickets tickets) {
        System.out.println("수동으로 "+ tickets.getManualSize()+"장, 자동으로 "+tickets.getAutoSize()+"개를 구매했습니다.");
        System.out.println(tickets.toString());
    }

    public void printResultMassage(WinningResult result) {
        System.out.println("당첨 통계\n" + "---------");
        System.out.println(result.toString());
        System.out.println("총 수익률은 " + result.getWinningPercent() + "% 입니다.");
    }
}
