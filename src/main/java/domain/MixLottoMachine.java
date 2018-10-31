package domain;


import utils.NumParser;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class MixLottoMachine extends LottoMachineAbstract implements Manually {
    private int manualLottoCount;

    public MixLottoMachine(int autoLottoCount, int manualLottoCount) {
        super(autoLottoCount);
        this.manualLottoCount = manualLottoCount;
    }

    @Override
    public void gerateManualLottos(int num) {
        List<Lotto> manualLottos = new ArrayList<>();
        while (true) {
            ResultView.requestManualLottoNum();
            manualLottos.clear();
            try {
                for (int i = 0; i < num; i++) {
                    Lotto lotto = Lotto.ofLotto(NumParser.parse(InputView.inputManualLottoNum()));
                    manualLottos.add(lotto);
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        lottos.addAll(manualLottos);
    }

    @Override
    public List<Lotto> getLottos() {
        gerateManualLottos(manualLottoCount);
        gerateAutoLottos(autoLottoCount);
        return lottos;
    }
}
