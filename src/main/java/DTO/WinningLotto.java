package DTO;

import lombok.Getter;
import model.Lotto;
import model.Rank;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
public class WinningLotto {
    private Map<Lotto, Rank> winningLotto;

    public WinningLotto() {
        this.winningLotto = new HashMap();
    }

    public Map<Lotto, Rank> putWinningLotto(Lotto lotto, Rank rank){
        winningLotto.put(lotto, rank);
        return winningLotto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WinningLotto)) {
            return false;
        }
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLotto, that.winningLotto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(winningLotto);
    }
}
