package lotto.type;

public enum WinningType {
    NONE(0, 0, "꽝!"),
    MATCH_THREE(3, 5000, "3개 일치 (5,000 원)"),
    MATCH_FOUR(4, 50000, "4개 일치 (50,000 원)"),
    MATCH_FIVE(5, 1500000, "5개 일치 (1,500,000 원)"),
    MATCH_FIVE_WITH_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000 원)"),
    MATCH_ALL(6, 2000000000, "6개 일치 (2,000,000,000 원)");

    WinningType(int matchCount, int prizes, String description) {
        this.matchCount = matchCount;
        this.prizes = prizes;
        this.description = description;
    }

    private int matchCount;
    private int prizes;
    private String description;

    public static WinningType parse(int matchCount, boolean isBonus){
        for(WinningType type : values()){
            if(MATCH_FIVE_WITH_BONUS.matchCount == matchCount && isBonus){
                return MATCH_FIVE_WITH_BONUS;
            }

            if(type.matchCount == matchCount) {
                return type;
            }
        }

        return WinningType.NONE;
    }

    public int getPrizes() {
        return prizes;
    }

    public String getDescription() {
        return description;
    }
}
