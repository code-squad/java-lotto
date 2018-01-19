package domain;

import java.util.List;

public class Lotto {
    private List<Integer> lotto;

    public Lotto(List<Integer> lotto){
        this.lotto = lotto;
    }

    public int countMatchLotto(WinningLotto winningLotto) {
        int count = 0;
        for(int userNumber : lotto){
            count += winningLotto.matchYn(userNumber);
        }
        return count;
    }

    public boolean hasBonus(WinningLotto winningLotto) {
        return winningLotto.hasBonus(lotto);
    }

    public int matchYn(int userNumber) {
        if(lotto.contains(userNumber)){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.join(", ", lotto.toString());
    }

}
