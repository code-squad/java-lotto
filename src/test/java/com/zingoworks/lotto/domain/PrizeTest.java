package com.zingoworks.lotto.domain;

import org.junit.jupiter.api.Test;

class PrizeTest {

    @Test
    void getCountOfMatch() {
        for(Prize prize: Prize.values())
        {
            System.out.println(prize.getCountOfHit());
        }
    }

    @Test
    void getWinningMoney() {
        for(Prize prize: Prize.values())
        {
            System.out.println(prize.getWinningMoney());
        }
    }
}