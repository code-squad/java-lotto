package javaLotto.domain;

public interface Match {
    int addPrice();
}

class match3 implements Match {
    private static final int MATCH_3_PRIZE_MONEY = 5000;
    @Override
    public int addPrice() {
        return MATCH_3_PRIZE_MONEY;
    }
}

class match4 implements Match {
    private static final int MATCH_4_PRIZE_MONEY = 50000;
    @Override
    public int addPrice() {
        return MATCH_4_PRIZE_MONEY;
    }
}

class match5 implements Match {
    private static final int MATCH_5_PRIZE_MONEY = 1500000;
    @Override
    public int addPrice() {
        return MATCH_5_PRIZE_MONEY;
    }
}

class match6 implements Match {
    private static final int MATCH_6_PRIZE_MONEY = 2000000000;
    @Override
    public int addPrice() {
        return MATCH_6_PRIZE_MONEY;
    }
}
