package domain;

import utils.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public abstract class LottoMachineAbstract implements Automatically {
    protected List<Lotto> lottos = new ArrayList<>();
    protected int autoLottoCount;

    public LottoMachineAbstract(int autoLottoCount) {
        this.autoLottoCount = autoLottoCount;
    }

    @Override
    public void gerateAutoLottos(int num) {
        for (int i = 0; i < num; i++) {
            lottos.add(LottoGenerator.generate());
        }
    }

    abstract public List<Lotto> getLottos();
}
