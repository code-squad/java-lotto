package dto;

import domain.Lotto;
import java.util.List;

public class LottoDto {
    private List<Lotto> autoLottos;
    private List<Lotto> handOperatedLottos;

    public LottoDto(List<Lotto> lottos, List<Lotto> handOperatedLottos) {
        this.autoLottos = lottos;
        this.handOperatedLottos = handOperatedLottos;
    }

    public List<Lotto> getAutoLottos() {
        return autoLottos;
    }

    public void setAutoLottos(List<Lotto> autoLottos) {
        this.autoLottos = autoLottos;
    }

    public List<Lotto> getHandOperatedLottos() {
        return handOperatedLottos;
    }

    public void setHandOperatedLottos(List<Lotto> handOperatedLottos) {
        this.handOperatedLottos = handOperatedLottos;
    }
}
