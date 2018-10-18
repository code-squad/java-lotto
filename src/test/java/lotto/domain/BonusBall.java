package lotto.domain;

public class BonusBall implements Checkable {
    private int lottoNumber;
    private Lotto lotto;

    private BonusBall(Lotto lotto, int lottoNumber) {
        this.lottoNumber = lottoNumber;
        this.lotto = lotto;
        check();
    }

    public boolean match(Lotto other){
        return other.isContain(this.lottoNumber);
    }

    @Override
    public void check() {
        if(!checkNumbers()) throw new IllegalArgumentException();
        if(!checkContain()) throw new IllegalArgumentException();
    }

    @Override
    public boolean checkNumbers(){
        if(this.lottoNumber < Lotto.MIN || this.lottoNumber > Lotto.MAX) return false;
        return true;
    }

    boolean checkContain(){
        return !lotto.isContain(this.lottoNumber);
    }

    public static BonusBall ofLottoAndText(Lotto lotto, String bonusBallText){
        int lottoNumber = Integer.parseInt(bonusBallText);
        return new BonusBall(lotto, lottoNumber);
    }
}
