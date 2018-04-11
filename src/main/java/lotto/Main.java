package lotto;

import lotto.domain.*;
import lotto.view.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // 구입금액 입력
        InputView inputView = new DefaultInputView();
        int purchasePrice = inputView.initPurchasePrice();

        // 구매한 로또 복권들
        List<LottoNumber> purchase = Lotto.purchase(purchasePrice);

        // 구매한 로또 복권 출력
        List<LottoViewDto> lottoViewDtos = lottoNumbersToLottoViewDtos(purchase);
        OutputView outputView = new DefaultOutputView(lottoViewDtos);
        outputView.printPurchasedLotto();

        // 지난 주 당첨 번호 입력
        List<Integer> lastPrizeOfNumbers = inputView.initLastPrizeOfNumber();
        LottoNumber lottoNumber = toLottoNumber(lastPrizeOfNumbers);

        // 당첨 결과
        Map<Prize, Integer> calculatedResult = PrizeCalculator.calculate(purchase, lottoNumber);

        // 총 수익률 계산
        int calculateEarningRate = PrizeCalculator.calculateEarningRate(purchasePrice, calculatedResult);

        // 당첨 통계 출력
        outputView.printLottoResult(calculatedResult, calculateEarningRate);
    }

    private static List<LottoViewDto> lottoNumbersToLottoViewDtos(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream().map(Main::lottoNumberToLottoViewDto).collect(Collectors.toList());
    }

    private static LottoViewDto lottoNumberToLottoViewDto(LottoNumber lottoNumber) {
        List<Integer> lottos = lottoNumber.getLottos().stream().map(LottoMeta::getNumber).collect(Collectors.toList());
        return new LottoViewDto(lottos);
    }

    private static LottoNumber toLottoNumber(List<Integer> lastPrizeOfNumbers) {
        return new LottoNumber(lastPrizeOfNumbers);
    }
}
