package lotto.domain;

public enum PriceType {
    FORTH(3, 5000), THIRD(4, 50000), SECOND(5, 1500000), FIRST(6, 2000000000);

    private int count;

    private int price;

    PriceType(int count, int price) {
        this.count = count;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public static PriceType getPriceType(int count) {
        for (PriceType priceType : PriceType.values()) {
            if (count == priceType.getCount()) {
                return priceType;
            }
        }
        return null;
    }
}
