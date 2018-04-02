package domain;

import java.util.ArrayList;
import java.util.List;

import static domain.LottoUtils.TICKET_PRICE;

public class User {

    private int presentMoney;
    private List<Lotto> lottos;
    private List<Integer> prizeStatistics;

    private User(int money) {
        if (!isValidMoney(money)) {
            throw new IllegalArgumentException(String.format("1000원 단위로 입력해 주세요. 입력값 : %d", money));
        }
        lottos = new ArrayList<>();
        presentMoney = money;
    }

    static boolean isValidMoney(int money) {
        return money > 0 && (money % TICKET_PRICE == 0);
    }

    public static User whoHasMoneyOf(int money) {
        return new User(money);
    }

    public void purchaseTicketsAuto(int numTickets) {
        lottos.addAll(Shop.sellAutoTickets(numTickets));
        presentMoney -= numTickets * TICKET_PRICE;
    }

    public void checkTotalResult(){
        checkPrizeStatistics();
        askForEarnings();
    }

    private void checkPrizeStatistics(){
        prizeStatistics = LotteryCommission.informResults(lottos);
    }

    private void askForEarnings() {
        presentMoney += LotteryCommission.giveEarnings(prizeStatistics);
    }

    public int calcProfit(){
        return presentMoney / (lottos.size() * TICKET_PRICE) * 100;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Integer> getPrizeStatistics() {
        return prizeStatistics;
    }

}
