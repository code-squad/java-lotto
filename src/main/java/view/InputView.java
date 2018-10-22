package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final int LOTTO_PRICE = 1000;
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해주세요.";
    private static final String INPUT_WIN_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int inputCount() throws IOException {
        System.out.println(INPUT_PRICE_MESSAGE);
        int count = Integer.parseInt(br.readLine()) / LOTTO_PRICE;
        ResultView.echoCount(count);
        return count;
    }

    public static String inputWinLottoText() throws IOException {
        System.out.println(INPUT_WIN_LOTTO_MESSAGE);
        return br.readLine();
    }

    public static int inputBonusBall() throws IOException {
        System.out.println(INPUT_BONUS_BALL_MESSAGE);
        return Integer.parseInt(br.readLine());
    }
}
