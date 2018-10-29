package domain;

import dto.LottoDto;
import utils.LottoGenerator;
import utils.Rank;
import utils.NumParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private List<Lotto> lottos;

    public LottoGame(List<Lotto> manualLottos) {
        lottos = new ArrayList<>(manualLottos);
    }

    public LottoDto generateLottos(int lottoTicketNum) {
        for (int i = 0; i < lottoTicketNum; i++) {
            lottos.add(LottoGenerator.generate());
        }
        return new LottoDto(lottos);
    }

    public GameResult checkLottos(String inputWinningNum, int bonus) {
        WinningLotto winningLotto = new WinningLotto(NumParser.parse(inputWinningNum), bonus);
        Map<Rank, Integer> gameResult = new HashMap<>();
        initGameResult(gameResult);
        for (Lotto lotto : lottos) {
            Rank rank = Rank.valueOf(lotto.strikeCheck(winningLotto), winningLotto.bonusCheck(lotto));
            putGameResult(gameResult, rank);
        }
        return new GameResult(gameResult);
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

}
