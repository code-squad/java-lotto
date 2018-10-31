package domain;

import java.util.List;

public class AutoLottoMachine extends LottoMachineAbstract{


    public AutoLottoMachine(int autoLottoCount) {
        super(autoLottoCount);
    }

    @Override
    public List<Lotto> getLottos() {
        gerateAutoLottos(autoLottoCount);
        return lottos;
    }
}
