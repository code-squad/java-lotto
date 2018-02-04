package dto;

import domain.lotto.LottoTicket;
import domain.lotto.Money;

public class LottoMoney {
    private Money money;

    private LottoMoney(Money money) {
        this.money = money;
    }

    public int getPurchasingTicketAmount() {
        return money.getValue() / LottoTicket.PRICE;
    }

    public Integer getMoney() {
        return money.getValue();
    }

    public static LottoMoney of(int inputMoney){
        return new LottoMoney(Money.of(inputMoney));
    }
}
