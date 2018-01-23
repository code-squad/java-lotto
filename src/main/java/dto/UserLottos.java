package dto;

import domain.Lotto;

import java.util.List;

public class UserLottos {
    List<Lotto> userLottos;

    public List<Lotto> getUserLottos() {
        return userLottos;
    }

    public void setUserLottos(List<Lotto> userLottos) {
        this.userLottos = userLottos;
    }
}
