import domain.Lotto;
import domain.LottoFactory;
import dto.LottoBundleDto;
import dto.ResultDto;
import util.StringParser;
import view.InputView;
import view.ResultView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        LottoBundleDto theLottoBundleDto = makeLottoBundleDto(theLottoBundle);
        ResultView.showLottoBundles(theLottoBundleDto);

        Set<Integer> lottoNumbers = makeLottoNumbers(InputView.inputWinLottoText());
        int[] winStats = theLottoBundle.calculateWinStats(LottoFactory.generateWinningLotto(lottoNumbers, InputView.inputBonusBall()));
        ResultDto theResultDto = new ResultDto(theLottoBundleDto, winStats);
        ResultView.showEarningRate(theResultDto);
    }

    private static Set<Integer> makeLottoNumbers(String lottoText){
        return StringParser.parseToNumbers(lottoText);
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
