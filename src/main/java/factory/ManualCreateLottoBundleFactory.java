package factory;

import domain.LottoBundle;
import dto.LottosDto;

import static util.Parser.*;

public class ManualCreateLottoBundleFactory implements LottoBundleFactory {

    private LottosDto lottosDto;

    private ManualCreateLottoBundleFactory(LottosDto lottosDto) {
        this.lottosDto = lottosDto;
    }

    public static ManualCreateLottoBundleFactory initManualCreateLotto(String lottoNumbValues) {
        return new ManualCreateLottoBundleFactory(strValueToLottoDto(lottoNumbValues));
    }

    @Override
    public LottoBundle createLottoBunddle() throws Exception {
        return LottoBundle.initArtifitial(this.lottosDto);
    }
}
