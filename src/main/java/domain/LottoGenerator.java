package domain;

import dto.LottoDto;
import dto.LottoDtos;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private List<Lotto> lottos;

    private LottoGenerator(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoGenerator initAuto(int lottoAmt) throws Exception {
        return new LottoGenerator(generateLotto(lottoAmt));
    }

    public static LottoGenerator initArtifitial(List<LottoDto> lottoDtos) throws Exception {
        List<Lotto> lottos = new ArrayList<>();
        for (LottoDto lottoDto : lottoDtos) {
            lottos.add(Lotto.initArtifitial(lottoDto.getLottoDto()));
        }
        return new LottoGenerator(lottos);
    }

    public static LottoGenerator initAutoAndArtifitial(LottoDtos lottos, int lottoAmt) throws Exception {
        List<LottoDto> lottoDtos = lottos.getLottoDtos();
        List<Lotto> result = generateLotto(lottoAmt - lottoDtos.size());

        for (LottoDto lottoDto : lottoDtos) {
            result.add(Lotto.initArtifitial(lottoDto.getLottoDto()));
        }

        return new LottoGenerator(result);
    }

    private static List<Lotto> generateLotto(int lottoAmt) throws Exception {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmt; i++) {
            lottos.add(Lotto.init());
        }

        return lottos;
    }

    public LottoDtos toLottoDtos() {
        List<LottoDto> dtos = new ArrayList<>();

        for (Lotto lotto : lottos) {
            dtos.add(lotto.toLottoDto());
        }
        return LottoDtos.init(dtos);
    }

}
