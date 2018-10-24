package domain;

public enum LottoResult {
    FIRST(6, 0), SECOND(5, 1), THIRD(5, 0), FOURTH(4, 0), FIFTH(3, 0), NONE(0, 0);

    private int lottoHit;
    private int bonusHit;

    LottoResult(int lottoHit, int bonusHit) {
        this.bonusHit = bonusHit;
        this.lottoHit = lottoHit;
    }

    /* 로또번호와 보너스 볼을 통해 결괄르 얻는 메소드 */
    public static LottoResult obtainLottoResult(int lottoHit, int bonusHit) {
        for(LottoResult lottoResult : values()) {
            if(lottoResult.isBiggerBonusHit(bonusHit) && lottoResult.isEqualLottoHit(lottoHit)) {
                return lottoResult;
            }
        }
        return LottoResult.NONE;
    }

    public boolean isEqualLottoHit(int lottoHit) {
        return this.lottoHit == lottoHit;
    }

    public boolean isBiggerBonusHit(int bonusHit) {
        return this.bonusHit <= bonusHit;
    }

    public static int obtainLottoHit(LottoResult targetLottoResult) {
        for(LottoResult lottoResult : values()) {
            if(lottoResult == targetLottoResult) {
                return lottoResult.lottoHit;
            }
        }
        return 0;
    }

    public static int obtainBonusHit(LottoResult targetLottoResult) {
        for(LottoResult lottoResult : values()) {
            if(lottoResult == targetLottoResult) {
                return lottoResult.bonusHit;
            }
        }
        return 0;
    }
}
