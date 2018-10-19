package com.zingoworks.lotto.domain;

import org.junit.jupiter.api.Test;

import static com.zingoworks.lotto.domain.Prize.FIRST;
import static org.junit.jupiter.api.Assertions.*;

class PrizeTest {

    @Test
    void getCountOfMatch() {
        for(Prize prize: Prize.values())
        {
            System.out.println(prize.getCountOfMatch());
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