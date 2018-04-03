package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.view.Output;

import static lotto.view.UserPrompt.*;

public class Main {

    public static void main(String[] args) {
        Lotto lotto = promptUserForPurchase();
        showReceipt(lotto);

        WinningLotto winningLotto = promptUserForWinningNumbers();
        getResult(lotto, winningLotto);
    }


    private static void showReceipt(Lotto lotto) {
        Output.showPurchase(lotto);
    }

    private static void getResult(Lotto lotto, WinningLotto winningLotto) {
        Output.getResult(lotto, winningLotto);
    }
}