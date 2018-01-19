package domain;

import java.util.List;

public class Lottos {
    private List<UserLotto> lottos;

    public Lottos(List<UserLotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public UserLotto get(int index) {
        return lottos.get(index);
    }
}
