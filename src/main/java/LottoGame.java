import domain.LottoBundle;
import domain.LottoBundleFactory;
import domain.LottoFactory;
import dto.LottoBundleDto;
import dto.ResultDto;
import util.StringParser;
import view.InputView;
import view.ResultView;

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

    private static void goLotto(){
        LottoBundle theLottoBundle = LottoBundleFactory.generateRandomLottoBundle(InputView.inputCount());
        LottoBundleDto theLottoBundleDto = theLottoBundle.toDto();
        ResultView.showLottoBundles(theLottoBundleDto);

        List<Integer> lottoNumbers = makeLottoNumber(InputView.inputWinLottoText());
        int[] winStats = theLottoBundle.calculateWinStats(LottoFactory.generateTheLotto(lottoNumbers));
        ResultDto theResultDto = new ResultDto(theLottoBundleDto, winStats);
        ResultView.showEarningRate(theResultDto);
    }

    private static List<Integer> makeLottoNumber(String lottoText){
        return StringParser.parseToNumbers(lottoText);
    }
}
