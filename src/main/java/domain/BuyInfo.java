package domain;

public class BuyInfo {
    private int totalMoney;
    private Tickets tickets;

    public BuyInfo(int totalMoney, Tickets tickets) {
        this.totalMoney = totalMoney;
        this.tickets = tickets;
    }
}
