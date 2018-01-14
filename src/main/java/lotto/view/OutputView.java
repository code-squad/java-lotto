package lotto.view;

import lotto.util.LottoUtils;

public class OutputView {
    private static final String UI_FORMAT = "[%s]";

    public static String lottoNumbersFormatting(int[] numbers) {
        return String.format(UI_FORMAT, String.join(LottoUtils.REGEX, LottoUtils.convertIntToString(numbers)));
    }

}
