package dto;

import domain.Lotto;

import java.util.List;

public class UserLotto {
    List<Lotto> userLotto;
    int totalCount;
    int autoLottoCount;
    int manualLottoCount;

    public UserLotto(List<Lotto> userLotto, int totalCount, int manualLottoCount) {
        this.userLotto = userLotto;
        this.totalCount = totalCount;
        this.manualLottoCount = manualLottoCount;
        this.autoLottoCount = totalCount-manualLottoCount;
    }

    public List<Lotto> getUserLotto() {
        return userLotto;
    }

    public void setUserLotto(List<Lotto> userLotto) {
        this.userLotto = userLotto;
    }
    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }

    public void setAutoLottoCount(int autoLottoCount) {
        this.autoLottoCount = autoLottoCount;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public void setManualLottoCount(int manualLottoCount) {
        this.manualLottoCount = manualLottoCount;
    }

    @Override
    public String toString() {
        return String.join(", ", this.userLotto.toString());
    }

}
