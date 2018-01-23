package lotto.domain;

public class WinningLotto {
    private Lotto lotto;
    private LottoNumber bonus;

    public WinningLotto(String numbers, int bonus) {
        this.lotto = new Lotto(numbers);
        this.bonus = new LottoNumber(bonus);

        if(lotto.contains(this.bonus)){
            throw new IllegalArgumentException();
        }
    }

    public int match(Lotto lotto){
        return this.lotto.matchCount(lotto);
    }

    public boolean isBonus(Lotto lotto){
        return lotto.contains(bonus);
    }

}
