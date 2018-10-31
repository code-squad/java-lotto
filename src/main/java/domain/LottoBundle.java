package domain;

import dto.LottoDto;
import dto.LottosDto;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {

    private List<Lotto> lottos;

    private LottoBundle(List<Lotto> lottos) {
        this.lottos = lottos;
    }


    public static LottoBundle initArtifitial(LottosDto lottosDto) throws Exception {
        List<Lotto> lottos = new ArrayList<>();
        for (LottoDto lottoDto : lottosDto.getLottoDtos()) {
            lottos.add(Lotto.initArtifitial(lottoDto.getLottoDto()));
        }
        return new LottoBundle(lottos);
    }


    public LottosDto toLottoDtos() {
        List<LottoDto> dtos = new ArrayList<>();

        for (Lotto lotto : lottos) {
            dtos.add(lotto.toLottoDto());
        }
        return LottosDto.init(dtos);
    }

}
