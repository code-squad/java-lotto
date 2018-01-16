import domain.*;


import java.util.ArrayList;
import java.util.List;

import static domain.LottoSeller.buyLotto;
import static view.InputView.*;
import static view.ResultView.*;

public class Main {
    public static void main(String[] args) {
        int investMoney = getInvestMoney();
        int numOfManualLotto = getNumOfManualLotto();
        List<List<Integer>> nums = getManualNums(numOfManualLotto);
        //List<Ticket> tickets = LottoSeller.buyTicket(nums);
        Lottos lottos = new Lottos(buyLotto(new BuyInfo(investMoney, new Tickets(new ArrayList<>())), new LottoNumCreator()));
        showNumOfBuyLotto(lottos.getNumOfLottos());
        showLottos(lottos);

        WinningLottos winningLottos = lottos.getWinningLottos(getWinningLotto());

        showResult(winningLottos, investMoney);
    }
}
