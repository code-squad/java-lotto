package saru;

public class Result {
    private int threeHit;
    private int fourHit;
    private int fiveHit;
    private int fiveHitBonus;
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

    public int getFiveHitBonus() {
        return fiveHitBonus;
    }

    public int getSixHit() {
        return sixHit;
    }

    // true를 넘겨야 보너스번호에 해당
    public void increaseHit(int match, boolean isBonus) {
        Rank rank = Rank.valueOf(match, isBonus);
        if (rank == null) {
            return;
        }

        switchProc(rank);
    }

    private void switchProc(Rank rank) {
        switch (rank) {
            case FIRST:
                sixHit++;
                break;
            case SECOND:
                fiveHitBonus++;
                break;
            case THIRD:
                fiveHit++;
                break;
            case FOURTH:
                fourHit++;
                break;
            case FIFTH:
                threeHit++;
                break;
        }
    }
}
