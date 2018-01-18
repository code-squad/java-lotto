package lotto.domain;

public enum Rank {
    FIRST(6, 2000000000), SECOND(5, 3000000), THIRD(5, 1500000), FORTH(4, 50000), FIFTH(3, 5000);

    private int count;

    private int price;

    Rank(int count, int price) {
        this.count = count;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public static Rank valueOf(int count, boolean matchBonus) {
        for (Rank rank : Rank.values()) {
            if (count == 5 && matchBonus) {
                return SECOND;
            } else if (rank.getCount() == count){
                return rank;
            }
        }
        return null;
    }
}
