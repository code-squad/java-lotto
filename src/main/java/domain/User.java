package domain;

import domain.exceptions.InvalidTicketNumException;

import java.util.ArrayList;
import java.util.List;

import static domain.LottoUtils.TICKET_PRICE;

public class User {

    private String name;
    private Money presentMoney;
    private List<Lotto> lottos;
    private List<Integer> prizeStatistics;

    private User(String name) {
        lottos = new ArrayList<>();
        this.name = name;
    }

    public static User nameOf(String name) {
        return new User(name);
    }

    public void hasMoneyOf(int inputMoney) {
        presentMoney = Money.of(inputMoney);
    }

    public void purchaseTicketsManual(List<LottoNoGroup> manualInput) {
        lottos.addAll(Shop.sellManualTickets(manualInput));
        presentMoney.withDraw(manualInput.size() * TICKET_PRICE);
    }

    public void purchaseTicketsAuto(int numTickets) {
        if (!isValidNumTickets(numTickets)) {
            throw new InvalidTicketNumException(String.format("0 이상의 값을 입력해 주세요 입력값 : %d", numTickets));
        }
        if (numTickets == 0) return;
        lottos.addAll(Shop.sellAutoTickets(numTickets));
        presentMoney.withDraw(numTickets * TICKET_PRICE);
    }

    static boolean isValidNumTickets(int numTickets) {
        return numTickets >= 0;
    }

    public void checkTotalResult() {
        checkPrizeStatistics();
        askForEarnings();
    }

    private void checkPrizeStatistics() {
        prizeStatistics = LotteryCommission.informResults(lottos);
    }

    private void askForEarnings() {
        presentMoney.depositEarnings(LotteryCommission.giveEarnings(prizeStatistics));
    }

    public int calcProfit() {
        return presentMoney.calcProfit();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Integer> getPrizeStatistics() {
        return prizeStatistics;
    }

    public Money getPresentMoney() {
        return presentMoney;
    }

    public int getLottoLength() {
        return lottos.size();
    }

    public int getProfit() {
        return calcProfit();
    }

    public String getName() {
        return name;
    }

}
