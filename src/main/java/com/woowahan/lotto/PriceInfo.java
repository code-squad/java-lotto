package com.woowahan.lotto;

public enum PriceInfo {
    THREE(3, 5000, 0), FOUR(4, 50000, 0), FIVE(5, 1500000, 0), SIX(6, 2000000000, 0);

    private final int value;
    private final int price;
    private int count;

    private PriceInfo(int value, int price, int count) {
        this.value = value;
        this.price = price;
        this.count = count;
    }

    public int getValue() {
        return value;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        this.count++;
    }
}
