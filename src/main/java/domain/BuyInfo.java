package domain;

import java.util.ArrayList;
import java.util.List;

public class BuyInfo {
    private Money totalMoney;
    private Tickets tickets;

    public BuyInfo(Money totalMoney, Tickets tickets) {
        if(totalMoney == null || tickets == null)
            throw new IllegalArgumentException("Invalid input exception");

        this.totalMoney = totalMoney;
        this.tickets = tickets;
    }

    public int getPurchasableQuantity(Money lottoPrice) {
        Money remainMoney = totalMoney.sub(lottoPrice.multi(tickets.getNumberOfTickets()));
        if(remainMoney.isLowerThan(lottoPrice))
            throw new IllegalArgumentException("Out of money");

        return remainMoney.devide(lottoPrice);
    }

    public int getPurchasableTotalQuantity(Money lottoPrice) {
        return totalMoney.devide(lottoPrice);
    }

    public List<Lotto> addManualLotto(Money lottoPrice) {
        List<Lotto> lottos = new ArrayList<>(getPurchasableTotalQuantity(lottoPrice));
        tickets.createLottos(lottos);

        return lottos;
    }
}
