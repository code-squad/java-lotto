import domain.Lotto;
import domain.LottoFactory;
import domain.WinStatsCalculator;
import domain.WinningLotto;
import dto.LottoBundleDto;
import dto.WinStatsDto;
import view.InputView;
import view.ResultView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public static void main(String[] args) {
        try {
            goLotto();
        } catch (Exception e){
            System.out.println("##Exception##");
            e.printStackTrace();
        }
    }

    private static void goLotto() throws IOException {
        List<Lotto> theLottoBundle = generateRandomLottoBundle(InputView.inputCount());
        ResultView.showLottoBundles(makeLottoBundleDto(theLottoBundle));
        WinningLotto theWinningLotto = LottoFactory.generateWinningLotto(InputView.inputWinningLottoNumbers(), InputView.inputBonusBall());
        WinStatsCalculator theWinStats =  new WinStatsCalculator(theLottoBundle, theWinningLotto);
        ResultView.showResultMessage(theWinStats.toDto());
    }


    public static List<Lotto> generateRandomLottoBundle(int count){
        List<Lotto> randomLottoBundle = new ArrayList<>();
        for(int i = 0; i < count; i++){
            randomLottoBundle.add(LottoFactory.generateRandomLotto());
        }
        return randomLottoBundle;
    }

    public static LottoBundleDto makeLottoBundleDto(List<Lotto> lottoBundle){
        LottoBundleDto theLottoBundleDto = new LottoBundleDto();
        for (Lotto lotto : lottoBundle) {
            theLottoBundleDto.add(lotto.toDto());
        }
        return theLottoBundleDto;
    }
}
