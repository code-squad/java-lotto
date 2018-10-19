package domain;

import dto.LottoDto;
import dto.ResultDto;
import utils.LottoNumGenerator;
import utils.LottoPrizeMapper;
import utils.MathHandler;
import utils.NumParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.LottoGameValues.LOTTO_SIZE;
import static utils.LottoGameValues.PRIZE_STRIKE_MAX;
import static utils.LottoGameValues.PRIZE_STRIKE_MIN;

public class LottoGame {
    private List<List<Integer>> lottos = new ArrayList<>();

    public LottoDto generateLottos(int lottoTicketNum) {
        for (int i = 0; i < lottoTicketNum; i++) {
            lottos.add(LottoNumGenerator.generate());
        }
        return new LottoDto(lottos);
    }

    public int[] checkLottosNum(String inputWinningNum) {
        LottoChecker lottoChecker = new LottoChecker(NumParser.parse(inputWinningNum));
        int[] strikeNums = new int[LOTTO_SIZE + 1];
        for (List<Integer> lotto : lottos) {
            strikeNums[lottoChecker.getStrikeNum(lotto)]++;
        }
        return strikeNums;
    }

    public ResultDto makeResultDto(int[] strikeNums, int purchaseAmount) {
        Map<Integer, Integer> strikeResults = putStrikeNums(strikeNums);
        int profitSum = calculateProfitNum(strikeNums);
        return new ResultDto(strikeResults, MathHandler.getProfit(profitSum, purchaseAmount));
    }

    private int calculateProfitNum(int[] strikeNums) {
        int tempProfitSum = 0;
        for (int i = PRIZE_STRIKE_MIN; i <= PRIZE_STRIKE_MAX; i++) {
            tempProfitSum += LottoPrizeMapper.get(i) * strikeNums[i];
        }
        return tempProfitSum;
    }

    private Map<Integer, Integer> putStrikeNums(int[] strikeNums) {
        Map<Integer, Integer> tempStrikeNums = new HashMap<>();
        for (int i = PRIZE_STRIKE_MIN; i <= PRIZE_STRIKE_MAX; i++) {
            tempStrikeNums.put(i, strikeNums[i]);
        }
        return tempStrikeNums;
    }
}
