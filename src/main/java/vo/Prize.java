package vo;

public enum Prize {
    THREE(3, 5000), FOUR(4, 50000), FIVE(5, 1500000), SIX(6, 2000000000);

    private int number;
    private int money;

    Prize(int number, int money) {
        this.number = number;
        this.money = money;
    }

    public static Prize getPrize(int cnt) {
        for (Prize prize : values()) {
            if (prize.number == cnt) return prize;
        }
        return null;
    }

    public int getMoney() {
        return money;
    }

    public int getNumber() {
        return number;
    }
}