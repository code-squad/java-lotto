package saru;

public class Result {
    private int threeHit;
    private int fourHit;
    private int fiveHit;
    private int sixHit;

    private Result() {
        // empty
    }

    public static Result of() {
        return new Result();
    }

    public int getThreeHit() {
        return threeHit;
    }

    public int getFourHit() {
        return fourHit;
    }

    public int getFiveHit() {
        return fiveHit;
    }

    public int getSixHit() {
        return sixHit;
    }

    public void increaseHit(int hitNum) {
        switch (hitNum) {
            case 3:
                this.threeHit++;
                break;
            case 4:
                this.fourHit++;
                break;
            case 5:
                this.fiveHit++;
                break;
            case 6:
                this.sixHit++;
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        return "Result{" +
                "threeHit=" + threeHit +
                ", fourHit=" + fourHit +
                ", fiveHit=" + fiveHit +
                ", sixHit=" + sixHit +
                '}';
    }
}
