package view;

import java.util.Scanner;

public class InputView {

    private static final int PRICE = 1000;


    public int inputMoeny(Scanner scanner){
        System.out.println("구매 금액을 입력해주세요.");

        int ammountOfLotto = calAmountOfLotto(scanner.nextInt());
        //OutputView.printAmountOfLotto(ammountOfLotto);

        return ammountOfLotto;
    }

    /**
     * 로또 가격 산출
     * @param money
     * @return
     */
    public int calAmountOfLotto(int money) {
        return money/PRICE;
    }
}
