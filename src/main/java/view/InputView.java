package view;

import util.StringParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class InputView {
    private static final int LOTTO_PRICE = 1000;
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해주세요.";
    private static final String INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_WIN_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "Please input number type";
    private static final String INPUT_MINIMUM_EXCEPTION_MESSAGE = "Can't enter less than 1000.";


    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int inputCount() throws IOException {
        System.out.println(INPUT_PRICE_MESSAGE);
        try{
            int price = Integer.parseInt(br.readLine());
            if(price < LOTTO_PRICE) throw new IllegalArgumentException(INPUT_MINIMUM_EXCEPTION_MESSAGE);
            return price / LOTTO_PRICE;
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

    public static List<String> inputManualLottoTexts(int manualLottoCount) throws IOException {
        List<String> lottoTexts = new ArrayList<>();
        if(manualLottoCount == 0) return lottoTexts;

        System.out.println(INPUT_MANUAL_LOTTO_MESSAGE);
        for (int i = 0; i < manualLottoCount; i++){
            lottoTexts.add(br.readLine());
        }
        return lottoTexts;
    }

    public static int inputManualLottoCount() throws IOException{
        System.out.println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE);
        try {
            return Integer.parseInt(br.readLine());
        }catch (NumberFormatException e){
            System.out.println(NUMBER_FORMAT_EXCEPTION_MESSAGE);
            return inputManualLottoCount();
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
