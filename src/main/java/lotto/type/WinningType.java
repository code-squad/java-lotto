package lotto.type;

public enum WinningType {
    NONE(0, 0),
    MATCH_THREE(3, 5000),
    MATCH_FOUR(4, 50000),
    MATCH_FIVE(5, 1500000),
    MATCH_ALL(6, 2000000000);

    WinningType(int matchCount, int prizes) {
        this.matchCount = matchCount;
        this.prizes = prizes;
    }

    private int matchCount;
    private int prizes;

    public static WinningType parse(int matchCount){
        for(WinningType type : WinningType.values()){
            if(type.matchCount == matchCount) return type;
        }

        return WinningType.NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizes() {
        return prizes;
    }
}
