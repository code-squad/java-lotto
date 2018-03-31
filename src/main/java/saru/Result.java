package saru;

public class Result {
    private static final int THREE_HIT = 3;
    private static final int FOUR_HIT = 4;
    private static final int FIVE_HIT = 5;
    private static final int SIX_HIT = 6;

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
            case THREE_HIT:
                this.threeHit++;
                break;
            case FOUR_HIT:
                this.fourHit++;
                break;
            case FIVE_HIT:
                this.fiveHit++;
                break;
            case SIX_HIT:
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
