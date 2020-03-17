package domain;

import dto.LottoPurchaseInfoDto;

import java.util.ArrayList;
import java.util.List;

import static domain.Lotto.LOTTO_PRICE;

public class LottoPurchaseInfo {
    private int numOfLotto;
    private List<Lotto> lottos = new ArrayList<>();

    // TODO : purchaseAmount 금액확인로직 필요
    public LottoPurchaseInfo(int purchaseAmount, LottoGenerator lottoGenerator) {
        this.numOfLotto = purchaseAmount / LOTTO_PRICE;
        generateLottos(lottoGenerator);
    }

    private void generateLottos(LottoGenerator lottoGenerator) {
        for (int i = 0; i < numOfLotto; i++) {
            lottos.add(lottoGenerator.generateLotto());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoPurchaseInfoDto toDto() {
        return new LottoPurchaseInfoDto(numOfLotto, lottos);
    }
}
