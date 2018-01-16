package domain;

import java.util.ArrayList;
import java.util.List;

public class BuyInfo {
    private int totalMoney;
    private Tickets tickets;

    public BuyInfo(int totalMoney, Tickets tickets) {
        if(totalMoney < 0 || tickets == null)
            throw new IllegalArgumentException("Invalid input exception");

        this.totalMoney = totalMoney;
        this.tickets = tickets;
    }

    public int getPurchasableQuantity(int lottoPrice) {
        int remainMoney = totalMoney - tickets.getNumberOfTickets() * lottoPrice;
        if(remainMoney < lottoPrice)
            throw new IllegalArgumentException("Out of money");

        return remainMoney / lottoPrice;
    }

    public int getPurchasableTotalQuantity(int lottoPrice) {
        return totalMoney / lottoPrice;
    }

    public List<Lotto> addManualLotto(ArrayList<Lotto> lottos) {
       // tickets(lottos)
        return null;
    }
}
