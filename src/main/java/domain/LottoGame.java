package domain;

import dto.LottoDto;
import dto.ResultDto;
import utils.LottoNumGenerator;
import utils.LottoPrize;
import utils.MathHandler;
import utils.NumParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.LottoGameValue.LOTTO_SIZE;
import static utils.LottoGameValue.PRIZE_MATCH_MAX;
import static utils.LottoGameValue.PRIZE_MATCH_MIN;

public class LottoGame {
    private List<List<Integer>> lottos = new ArrayList<>();

    public LottoDto makeLottoDto(int lottoTicketNum) {
        for (int i = 0; i < lottoTicketNum; i++) {
            lottos.add(LottoNumGenerator.generate());
        }
        return new LottoDto(lottos);
    }

    public int[] checkLotto(String inputWinningNums) {
        LottoChecker lottoChecker = new LottoChecker(NumParser.parse(inputWinningNums));
        int[] matchPoint = new int[LOTTO_SIZE + 1];
        for (List<Integer> lotto : lottos) {
            matchPoint[lottoChecker.getMatchNum(lotto)]++;
        }
        return matchPoint;
    }

    public ResultDto makeResultDto(int[] matchPoint, int purchaseAmount) {
        Map<Integer, Integer> matchResult = new HashMap<>();
        int profitSum = 0;
        for (int i = PRIZE_MATCH_MIN; i <= PRIZE_MATCH_MAX; i++) {
            matchResult.put(i, matchPoint[i]);
            profitSum += LottoPrize.getLottoPrize(i) * matchPoint[i];
        }
        return new ResultDto(matchResult, MathHandler.getProfit(profitSum, purchaseAmount));
    }
}
