package factory;

import domain.Lotto;
import domain.LottoBundle;
import dto.LottoDto;
import dto.LottosDto;
import vo.No;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static util.RandomGenerator.generateLottoNum;

public class AutoCreateLottoBudleFactory implements LottoBundleFactory {

    private int autoCreatelottoAmt;

    private AutoCreateLottoBudleFactory(int autoCreatelottoAmt) {
        this.autoCreatelottoAmt = autoCreatelottoAmt;
    }

    public static AutoCreateLottoBudleFactory initAutoCreateLottoAmt(int autoCreatelottoAmt) {
        return new AutoCreateLottoBudleFactory(autoCreatelottoAmt);
    }

    private List<LottoDto> generateLotto(int lottoAmt) throws Exception {
        List<LottoDto> lottosDto = new ArrayList<>();
        for (int i = 0; i < lottoAmt; i++) {
            lottosDto.add(LottoDto.init(makeLotto()));
        }

        return lottosDto;
    }

    private List<No> makeLotto() {
        Set<No> lotto = new HashSet<>();
        while (lotto.size() < Lotto.LOTTO_SIZE) {
            lotto.add(new No(generateLottoNum()));
        }

        return new ArrayList<>(lotto);
    }

    @Override
    public LottoBundle createLottoBunddle() throws Exception {
        return LottoBundle.initArtifitial(LottosDto.init(generateLotto(this.autoCreatelottoAmt)));
    }
}
