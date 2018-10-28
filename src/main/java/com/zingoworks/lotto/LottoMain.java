package com.zingoworks.lotto;

import com.zingoworks.lotto.domain.LottoResult;
import com.zingoworks.lotto.domain.Lottos;
import com.zingoworks.lotto.domain.WinningLotto;
import com.zingoworks.lotto.view.InputView;
import com.zingoworks.lotto.view.ResultView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        //입력하는 돈과 수익률 계산 등을 담당할 Money 객체를 추가하는 것은 어떨까?
        //Money를 추가하는 것이 의미있을까?

//        Auto, Manual을 나누는 것도 좋음.
//                이런 인터페이스를 통해 구현하는 것은 어떨까?
//        public interface LottosGenerator {
//            List<Lotto> generate(Money money);
//        }
        try {
            int purchaseAmount = InputView.inputPurchaseAmount();
            int manualLottoAmounts = InputView.inputManualLottoAmounts();
            List<String> manualLottoNumbers = InputView.inputManualLottoNumbers(manualLottoAmounts);

            Lottos lottos = new Lottos(purchaseAmount, manualLottoNumbers);
            ResultView.printLottoNumbers(lottos);

            String lastWinningNumbers = InputView.inputLastWinningNumbers();
            int bonusNumber = InputView.inputBonusNumber();
            WinningLotto winningLotto = new WinningLotto(lastWinningNumbers, bonusNumber);
            LottoResult lottoResult = lottos.match(winningLotto);

            ResultView.printResults(lottoResult, purchaseAmount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            main(args);
        }
    }
}