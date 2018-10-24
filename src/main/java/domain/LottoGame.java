package domain;

import dto.LottoDto;
import dto.StrikeDto;
import utils.LottoGenerator;
import utils.Rank;
import utils.MathHandler;
import utils.NumParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private List<Lotto> lottos = new ArrayList<>();

    public LottoDto generateLottos(int lottoTicketNum) {
        for (int i = 0; i < lottoTicketNum; i++) {
            lottos.add(LottoGenerator.generate());
        }
        return new LottoDto(lottos);
    }

    // LottoChecker에게 이관
    public List<StrikeDto> checkLottos(String inputWinningNum, int bonus) {
        LottoChecker lottoChecker = new LottoChecker(new WinningLotto(NumParser.parse(inputWinningNum), bonus));
        List<StrikeDto> strikeDtos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            strikeDtos.add(lottoChecker.checkLotto(lotto));
        }
        return strikeDtos;
    }

    public Map<Rank, Integer> assignGameResult(List<StrikeDto> strikeDtos) {
        Map<Rank, Integer> gameResult = new HashMap<>();
        initGameResult(gameResult);
        for (StrikeDto strikeDto : strikeDtos) {
            Rank rank = Rank.valueOf(strikeDto.getStrikePoint(), strikeDto.getStrikeBonus());
            putGameResult(gameResult, rank);
        }
        return gameResult;
    }

    private void initGameResult(Map<Rank, Integer> gameResult) {
        for (Rank rank : Rank.values()) {
            gameResult.put(rank, 0);
        }
    }

    private void putGameResult(Map<Rank, Integer> gameResult, Rank rank) {
        if (rank != null) {
            gameResult.put(rank, gameResult.get(rank) + 1);
        }
    }

    public int calculateProfitRate(Map<Rank, Integer> gameResult, int purchaseAmount) {
        int tempProfitSum = 0;
        for (Rank rank : gameResult.keySet()) {
            tempProfitSum += rank.getWinningMoney() * gameResult.get(rank);
        }
        return MathHandler.getProfit(tempProfitSum, purchaseAmount);
    }

}
