package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Prize;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Moonchan on 2018. 1. 16..
 */
public class ResultView {

    private static final String RESULT_TITLE = "당첨 통계";
    private static final String RETURN_RATE_MESSAGE_FORMAT = "총 수익률은 %.2f%%입니다.";
    private static final String SEPARATOR_LINE = "------------------";

    private LottoResult lottoResult;

    public ResultView(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }

    public void printReport() {
        System.out.println(RESULT_TITLE);
        System.out.println(SEPARATOR_LINE);
        System.out.println(getPrizeListString());
        System.out.println(String.format(RETURN_RATE_MESSAGE_FORMAT, lottoResult.getReturnRate()));
    }

    public String getPrizeListString() {
        ArrayList<String> prizeStringList = new ArrayList<>();
        for (Prize prize : Prize.values()) {
            if(prize == Prize.NONE)
                continue;
            prizeStringList.add(getPrizeString(prize));
        }
        Collections.sort(prizeStringList);
        return String.join("\n", prizeStringList);
    }

    private String getPrizeString(Prize prize) {
        int count = lottoResult.getPrizeCount(prize);
        int matchNumberCount = LottoNumber.LOTTO_NUMBERS_SIZE - prize.getPrizeNumber() + 1;
        return String.format("%d개 일치 (%d원)- %d개", matchNumberCount, prize.getReward(), count);
    }
}
