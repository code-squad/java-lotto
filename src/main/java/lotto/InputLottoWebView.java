package lotto;

import lotto.exception.ManualPurchaseLessThanZeroException;
import lotto.exception.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputLottoWebView {

    public static Money inputMoney(String money) throws IllegalArgumentException {
        if (isNotValidationFormat(money)) {
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }

        return new Money(stringToInt(money));
    }

    public static List<String> inputPurchaseManualLotto(String inputManualLottoNumbers, Money money) throws IllegalArgumentException {
        if (inputManualLottoNumbers == null || inputManualLottoNumbers.isEmpty()) {
            return new ArrayList<>();
        }
        return inputPurchaseManualLotto(split(inputManualLottoNumbers), money);
    }

    private static List<String> inputPurchaseManualLotto(String[] inputManualLottoNumbers, Money money) throws IllegalArgumentException {
        List<String> manualLottoNumbers = new ArrayList<>();
        for (String inputManualLottoNumber : inputManualLottoNumbers) {
            manualLottoNumbers.add(inputManualLottoNumber);
        }
        return checkPurchaseManualLottoCount(manualLottoNumbers, money);
    }

    private static String[] split(String input) {
        return input.split("\n");
    }

    public static List<String> checkPurchaseManualLottoCount(List<String> manualLottoNumbers, Money money) {
        int manualCount = manualLottoNumbers.size();
        if (manualCount < 0) {
            throw new ManualPurchaseLessThanZeroException();
        }

        if (money.isExceedMoney(manualCount)) {
            throw new NotEnoughMoneyException();
        }

        return manualLottoNumbers;
    }

    public static int inputBonus(Lotto lotto, String bonusNumber) throws IllegalArgumentException {
        if (isNotValidationFormat(bonusNumber)) {
            throw new IllegalArgumentException();
        }

        return inputBonus(lotto, stringToInt(bonusNumber));
    }

    private static boolean isNotValidationFormat(String value) {
        if (value == null || value.isEmpty()) {
            return true;
        }

        if (isNotNumberFormat(value)) {
            return true;
        }

        return false;
    }

    private static boolean isNotNumberFormat(String value) {
        Pattern pattern = Pattern.compile("^[1-9][0-9]*");
        Matcher matcher = pattern.matcher(value);

        if (!matcher.find()) {
            return true;
        }
        return false;
    }

    private static int inputBonus(Lotto lotto, int bonusNumber) throws IllegalArgumentException {
        return lotto.checkDuplicateBonusNumber(LottoNumber.checkLottoNumberRange(bonusNumber));
    }

    private static int stringToInt(String value) {
        return Integer.parseInt(value);
    }

}