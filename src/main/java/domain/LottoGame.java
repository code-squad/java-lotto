package domain;

import dto.LottoDto;
import utils.LottoGenerator;
import utils.Rank;
import utils.NumParser;

import java.util.*;

public class LottoGame {

    public LottoDto generateLottos(int lottoTicketNum, int manualLottoTicketCount) {
        LottoMachineAbstract lottoMachine;
        if (manualLottoTicketCount == 0) {
            lottoMachine = new AutoLottoMachine(lottoTicketNum - manualLottoTicketCount);
            return new LottoDto(lottoMachine.getLottos());
        }
        int autoLottoCount = lottoTicketNum - manualLottoTicketCount;
        lottoMachine = new MixLottoMachine(autoLottoCount, manualLottoTicketCount);
        return new LottoDto(lottoMachine.getLottos());
    }

    public GameResult checkLottos(WinningLotto winningLotto, LottoDto lottos) {
        Map<Rank, Integer> gameResult = new HashMap<>();
        initGameResult(gameResult);
        for (Lotto lotto : lottos.getLottos()) {
            Rank rank = Rank.valueOf(lotto.strikeCheck(winningLotto), winningLotto.bonusCheck(lotto));
            putGameResult(gameResult, rank);
        }
        return new GameResult(gameResult);
    }

    void initGameResult(Map<Rank, Integer> gameResult) {
        Arrays.stream(Rank.values()).forEach(rank -> gameResult.put(rank, 0));
    }

    private void putGameResult(Map<Rank, Integer> gameResult, Rank rank) {
        Optional<Rank> optionalRank = Optional.ofNullable(rank);
        if (optionalRank.isPresent()) {
            gameResult.put(optionalRank.get(), gameResult.get(optionalRank.get()) + 1);
        }
    }

}
