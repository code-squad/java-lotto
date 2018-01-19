package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {

    private List<Lotto> lottos = new ArrayList<>();

    public LottoStore(int money, List<String> manualLottos) {
        if (isNotMoneyRange(money)) {
            throw new IllegalArgumentException();
        }
        int count = money / 1000;
        setManualLottos(manualLottos);
        setAutoLottos(count - manualLottos.size());
    }

    private void setAutoLottos(int autoLottoCount) {
        while (autoLottoCount > 0) {
            lottos.add(new Lotto());
            autoLottoCount--;
        }
    }

    private void setManualLottos(List<String> manualLottos) {
        for (String manualLotto : manualLottos) {
            lottos.add(new Lotto(convertToLottoNo(manualLotto).collect(Collectors.toList())));
        }
    }

    private Stream<LottoNo> convertToLottoNo(String manualLotto) {
        return Arrays.stream(split(manualLotto)).map(i -> new LottoNo(toInt(i)));
    }

    private int toInt(String number) {
        return Integer.parseInt(number);
    }

    private String[] split(String manualLotto) {
        return manualLotto.split(",");
    }

    private boolean isNotMoneyRange(int money) {
        return money % 1000 != 0 || money < 1000 || money > 1000000000;
    }

    public LottoStore(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public LottoResult match(WinningLotto winningLotto) {
        return new LottoResult(this.lottos, winningLotto);
    }




}
