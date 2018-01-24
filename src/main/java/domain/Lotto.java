package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static domain.LottoNumber.convertLottoNumber;

public class Lotto {
    private List<LottoNumber> lotto;

    public Lotto(){

        this.lotto = LottoNumber.getLotto();
    }

    public Lotto(List<Integer> lotto){

        this.lotto = convertLottoNumber(lotto);
    }

    public int countMatchLotto(WinningLotto winningLotto) {
        int count = 0;
        for(LottoNumber userNumber : this.lotto){
            count += winningLotto.matchYn(userNumber);
        }
        return count;
    }

    // 객체 지향적인 설계를 하다 보면 아래의 hasBonus와 같이 다른 객체에게 행위를 위임하는 동작만을 하는 메소드들이 많이 나오게 된다.
    public boolean hasBonus(WinningLotto winningLotto) {
        return winningLotto.hasBonus(lotto);
    }

    public int matchYn(LottoNumber userNumber) {
        if(userNumber.contains(this.lotto)){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.join(", ", this.lotto.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lotto);
    }
}
