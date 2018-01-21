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

    // 객체 지향적인 설계를 하다 보면 아래의 hasBonus와 같이 다른 객체에게 행위를 위임하는 동작만을 하는 메소드들이 많이 나오게 된다.
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
