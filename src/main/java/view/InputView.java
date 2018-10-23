package view;

import util.StringParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class InputView {
    private static final int LOTTO_PRICE = 1000;
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해주세요.";
    private static final String INPUT_WIN_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = System.lineSeparator() + "# Error : Please input number type";

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int inputCount() throws IOException {
        System.out.println(INPUT_PRICE_MESSAGE);
        try{
            return Integer.parseInt(br.readLine()) / LOTTO_PRICE;
        }catch (NumberFormatException e){
            System.out.println(NUMBER_FORMAT_EXCEPTION_MESSAGE);
            return inputCount();
        }
    }

    public static Set<Integer> inputWinningLottoNumbers() throws IOException {
        System.out.println(INPUT_WIN_LOTTO_MESSAGE);
        try {
            return StringParser.parseToNumbers(br.readLine());
        }catch (NumberFormatException e){
            System.out.println(NUMBER_FORMAT_EXCEPTION_MESSAGE);
            return inputWinningLottoNumbers();
        }
    }

    public static int inputBonusBall() throws IOException {
        System.out.println(INPUT_BONUS_BALL_MESSAGE);
        try {
            return Integer.parseInt(br.readLine());
        }catch (NumberFormatException e){
            System.out.println(NUMBER_FORMAT_EXCEPTION_MESSAGE);
            return inputBonusBall();
        }
    }
}
