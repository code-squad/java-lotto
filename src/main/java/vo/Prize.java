package vo;

public enum Prize {
    FIFTH(3, 5_000), FOURTH(4, 50_000), THIRD(5, 1_500_000), SECOND(5, 30_000_000), FIRST(6, 2_000_000_000);

    private int number;
    private int money;

    Prize(int number, int money) {
        this.number = number;
        this.money = money;
    }

    public static Prize getPrize(int cnt, boolean bonus) {
        for (Prize prize : values()) {
            if (prize.number == SECOND.number) {
                return bonus ? SECOND : THIRD;
            }
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