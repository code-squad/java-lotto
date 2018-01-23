package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {

    private List<Lotto> lottos = new ArrayList<>();

    public LottoStore(Money money, List<String> manualLottos) {
        int count = money.buyableLottoCount();
        setManualLottos(manualLottos);
        setAutoLottos(count - manualLottos.size());
    }

    private void setAutoLottos(int autoLottoCount) {
        while (autoLottoCount > 0) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
            autoLottoCount--;
        }
    }

    private void setManualLottos(List<String> manualLottos) {
        for (String manualLotto : manualLottos) {
            lottos.add(new Lotto(convertToLottoNo(manualLotto).collect(Collectors.toList())));
        }
    }

    private Stream<LottoNo> convertToLottoNo(String manualLotto) {
        return Arrays.stream(split(manualLotto)).map(i -> toInt(i)).collect(Collectors.toList()).stream().map(i -> new LottoNo(i));
    }


    private int toInt(String number) {
        return Integer.parseInt(number);
    }

    private String[] split(String manualLotto) {
        return manualLotto.split(",");
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
