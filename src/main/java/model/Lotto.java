package model;

public class Lotto {
    private int price;

    public Lotto(int price) {
        this.price = price;
    }

    public int countOfLotto() {
        return price / 1000;
    }
}
