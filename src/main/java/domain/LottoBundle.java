package domain;

import dto.LottoBundleDto;
import dto.LottoDto;
import dto.ResultDto;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {
    private List<Lotto> lottos;

    public LottoBundle(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoBundleDto toDto() {
        List<LottoDto> lottoDtos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoDtos.add(lotto.toDto());
        }

        return new LottoBundleDto(lottoDtos);
    }

    public ResultDto checkWin(Lotto winnerLotto) {
        ResultDto resultDto = new ResultDto();
        for (Lotto lotto : lottos) {
            resultDto.pushResult(lotto.checkNum(winnerLotto));
        }

        return resultDto;

    }
}
