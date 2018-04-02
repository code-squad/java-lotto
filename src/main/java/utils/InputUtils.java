package utils;

import domain.Lotto;
import domain.LottoNum;

import java.util.ArrayList;
import java.util.List;

public class InputUtils {
    public static void verifyManualAmount(int totalAmount, int manualAmount) {
        if (isOverTotalAmount(totalAmount, manualAmount)) {
            throw new IllegalArgumentException("전체 구매개수보다 수동 지정한 개수가 많습니다.");
        }

        if (isNegativeAmount(manualAmount)) {
            throw new IllegalArgumentException("수동 구매 가능 개수(0개 이상 " + totalAmount + "개 이하)");
        }
    }

    public static boolean isOverTotalAmount(int totalAmount, int manualAmount) {
        return totalAmount < manualAmount;
    }

    public static boolean isNegativeAmount(int manualAmount) {
        return manualAmount < 0;
    }

    public static String[] parseLottoNumbers(String lottoNumbers) {
        String spaceRemovedNumbers = removeSpace(lottoNumbers);
        return spaceRemovedNumbers.split(",");
    }

    private static String removeSpace(String lottoNumbers) {
        return lottoNumbers.replaceAll(" ", "");
    }

    public static int convertNumber(String numberMessage) throws IllegalArgumentException {
        try {
            return Integer.parseInt(numberMessage);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자만 입력해야합니다.");
        }
    }

    public static LottoNum convertLottoNum(String numberMessage) throws IllegalArgumentException {
        return new LottoNum(convertNumber(numberMessage));
    }

    public static List<LottoNum> convertLottoNum(String[] numberMessage) throws IllegalArgumentException {
        List<LottoNum> numbers = new ArrayList<>();
        for (String number : numberMessage) {
            numbers.add(convertLottoNum(number));
        }
        return numbers;
    }

    public static String[] splitLottoNumbers(String lottoNumber) {
        return lottoNumber.split("\r?\n");
    }

    public static List<String[]> parseLottoNumbers(String[] lottoNumbers) {
        ArrayList<String[]> numbers = new ArrayList<>();
        for (String number : lottoNumbers) {
            numbers.add(parseLottoNumbers(number));
        }
        return numbers;
    }

    public static List<Lotto> convertLottos(List<String[]> lottoNumbers) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (String[] numbers : lottoNumbers) {
            lottos.add(new Lotto(convertLottoNum(numbers)));
        }
        return lottos;
    }
}
