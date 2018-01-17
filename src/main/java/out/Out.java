package out;

import DTO.WinningResult;
import domain.lotto.LottoTicket;

import java.util.List;

public class Out {

    public void printBuyConfirmMassage(List<LottoTicket> tickets) {
        for (int i = 0; i < tickets.size(); i++) {
            System.out.println(tickets.get(i).toString());
        }
        System.out.println(tickets.size() + "개를 구매하셨습니다.");
    }

    public void printResultMassage(WinningResult result){
        System.out.println("당첨 통계\n" + "---------");
        System.out.println(result.toString());
    }
}
