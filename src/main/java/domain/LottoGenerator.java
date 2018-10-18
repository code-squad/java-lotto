package domain;

import dto.LottoDto;
import dto.LottoDtos;
import dto.NoDto;
import dto.WinResultDto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottos;

    private LottoGenerator(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoGenerator init(int lottoAmt) {
        return new LottoGenerator(generateLotto(lottoAmt));
    }

    public static LottoGenerator initArtifitial(List<Lotto> lottos) {
        return new LottoGenerator(lottos);
    }

    private static List<Lotto> generateLotto(int lottoAmt) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmt; i++) {
            lottos.add(Lotto.init());
        }

        return lottos;
    }

    public WinResultDto checkWins(LottoDto winningLottoDto, NoDto bonusNo) {
        WinningLotto winningLotto = WinningLotto.init(Lotto.initArtifitial(winningLottoDto.getLottoDto()), No.initInt(bonusNo.getNum()));

        return makeWinResultDto(winningLotto, WinResultDto.init());
    }

    public WinResultDto makeWinResultDto(WinningLotto winningLotto, WinResultDto resultDto) {
        for (Lotto lotto : lottos) {
            resultDto.setRankAmt(winningLotto.compareWinLottoNum(lotto));
        }
        return resultDto;
    }

    public LottoDtos toLottoDtos() {
        List<LottoDto> dtos = new ArrayList<>();

        for (Lotto lotto : lottos) {
            dtos.add(lotto.toLottoDto());
        }
        return LottoDtos.init(dtos);
    }

}
