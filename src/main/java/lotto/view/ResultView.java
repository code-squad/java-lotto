package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
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

    public static void printReport(LottoResult lottoResult) {
        System.out.println(RESULT_TITLE);
        System.out.println(SEPARATOR_LINE);
        System.out.println(getPrizeListString(lottoResult));
        System.out.println(String.format(RETURN_RATE_MESSAGE_FORMAT, lottoResult.getReturnRate()));
    }

    public static String getPrizeListString(LottoResult lottoResult) {
        ArrayList<String> prizeStringList = new ArrayList<>();
        for (Prize prize : Prize.values()) {
            if(prize == Prize.NONE)
                continue;
            prizeStringList.add(getPrizeString(prize, lottoResult.getPrizeCount(prize)));
        }
        Collections.sort(prizeStringList);
        return String.join("\n", prizeStringList);
    }

    private static String getPrizeString(Prize prize, int count) {
        int matchNumberCount = LottoTicket.LOTTO_NUMBERS_SIZE - prize.getCountOfDifference();
        return String.format("%d개 일치 (%d원)- %d개", matchNumberCount, prize.getReward(), count);
    }
}
