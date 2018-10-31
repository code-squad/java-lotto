package control;

import domain.Lotto;
import utils.NumParser;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoControl {

    public static List<Lotto> getManualLottos(int manualLottoTicketCount) {
        List<Lotto> manualLottos = new ArrayList<>();
        while (true) {
            ResultView.requestManualLottoNum();
            manualLottos.clear();
            try {
                for (int i = 0; i < manualLottoTicketCount; i++) {
                    Lotto lotto = Lotto.ofLotto(NumParser.parse(InputView.inputManualLottoNum()));
                    manualLottos.add(lotto);
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return manualLottos;
    }
}
