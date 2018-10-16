package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final int LOTTO_PRICE = 1000;
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해주세요.";
    private static final String INPUT_WIN_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int inputCount() {
        System.out.println(INPUT_PRICE_MESSAGE);
        int count = 0;
        try {
            count = Integer.parseInt(br.readLine()) / LOTTO_PRICE;
        } catch (IOException e) {
            e.printStackTrace();
        }
        ResultView.echoCount(count);
        return count;
    }

    public static String inputWinLottoText(){
        System.out.println(INPUT_WIN_LOTTO_MESSAGE);
        String winLottoText = "";
        try {
            winLottoText = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return winLottoText;
    }
}
