package model.gameResult;

public class GameResult {
    private int matchCount;
    private int price;

    private GameResult(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static GameResult of(int matchCount) {
        switch (matchCount) {
            case 3:
                return new GameResult(5000);
            case 4:
                return new GameResult(50000);
            case 5:
                return new GameResult(1500000);
            case 6:
                return new GameResult(2000000000);
        }
        return new GameResult(0);
    }
}