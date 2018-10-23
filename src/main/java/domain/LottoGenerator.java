package domain;

import dto.LottoDto;
import dto.LottoDtos;
import dto.WinResultDto;
import vo.No;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private List<Lotto> lottos;

    private LottoGenerator(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoGenerator initAuto(int lottoAmt) {
        return new LottoGenerator(generateLotto(lottoAmt));
    }

    public static LottoGenerator initArtifitial(List<Lotto> lottos) {
        return new LottoGenerator(lottos);
    }

    public static LottoGenerator initAutoAndArtifitial(LottoDtos lottos, int lottoAmt) {
        List<LottoDto> lottoDtos = lottos.getLottoDtos();
        List<Lotto> result = generateLotto(lottoAmt - lottoDtos.size());

        for (LottoDto lottoDto : lottoDtos) {
            result.add(Lotto.initArtifitial(lottoDto.getLottoDto()));
        }

        return new LottoGenerator(result);
    }

    private static List<Lotto> generateLotto(int lottoAmt) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmt; i++) {
            lottos.add(Lotto.init());
        }

        return lottos;
    }

    public WinResultDto checkWins(LottoDto winningLottoDto, No bonusNo) {
        WinningLotto winningLotto = new WinningLotto(Lotto.initArtifitial(winningLottoDto.getLottoDto()), bonusNo);

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
