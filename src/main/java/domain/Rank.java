package domain;

import java.util.Arrays;

public enum Rank {
    ONE(6, 2000000000), TWO(5, 30000000), THREE(5, 1500000), FOUR(4, 50000), FIVE(3, 5000);
    private final int trueNum;
    private final int money;

    Rank(int num, int money) {
        this.trueNum = num;
        this.money = money;
    }

    public static Rank valueOf(int count, boolean bonus) {
        return Arrays.stream(Rank.values())
                .filter(type -> type.matchNum(count, bonus))
                .findFirst()
                .orElse(null);
    }

    public boolean matchNum(int count, boolean bonus) {
        return count == TWO.trueNum ?
                (bonus ? this == TWO : this == THREE)
                : this.trueNum == count;
    }

    public int multiplicationMoney(int count) {
        return money * count;
    }

    public int getMoney() {
        return money;
    }

    public int getTrueNum() {
        return trueNum;
    }


}

