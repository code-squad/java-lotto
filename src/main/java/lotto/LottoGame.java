package lotto;

import java.util.Scanner;

import lotto.model.LottoGenerator;
import lotto.model.Lottos;
import lotto.model.Result;
import lotto.model.WinningLotto;
import lotto.view.LottoFormView;
import lotto.view.LottoResultView;

public class LottoGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = LottoFormView.inputMoney(scanner);
        WinningLotto winningLotto = LottoFormView.inputWinningLotto(scanner);
        
        Lottos lottos = LottoGenerator.generateByMoney(money);
        System.out.println(lottos);
        
        Result result = lottos.match(winningLotto);

        LottoResultView.show(result);
        scanner.close();
    }
}
