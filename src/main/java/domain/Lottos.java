package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private static final int ticketCost = 1000;

    private List<Lotto> lottos;

    private Lottos() {
        this.lottos = new ArrayList<Lotto>();
    }

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of() {
        return new Lottos();
    }

    public static Lottos initLottosAuto(int n) {
        return new Lottos(IntStream.range(0, n).mapToObj(i -> Lotto.of(LottoUtil.getRandNumbers())).collect(Collectors.toList()));
    }

    public void addLottosManual(List<Integer> numbers) {
        this.lottos.add(Lotto.of(numbers));
    }

    public List<Rank> getLottoRanks(WinningLotto winningLotto) {
        return lottos.stream().map(i -> i.getRank(winningLotto)).collect(Collectors.toList());
    }

    public int getMatchLottos(WinningLotto winningLotto, Rank rank) {
        return (int) getLottoRanks(winningLotto).stream().filter(factor -> factor == rank).count();
    }

    public List<Integer> getResult(WinningLotto winningLotto) {
        return Arrays.stream(Rank.values()).mapToInt(i -> getMatchLottos(winningLotto, i)).boxed().collect(Collectors.toList());
    }

    public int calcProfit(WinningLotto winningLotto) {
        int totalPrize = 0;
        List<Integer> prizeResults = getResult(winningLotto);
        for (int i = 0; i < prizeResults.size(); i++){
            totalPrize += prizeResults.get(i)*Rank.values()[i].getWinningMoney();
        }
        int bettingMoney = ticketCost * lottos.size();
        return (int)(((double)totalPrize - (double)bettingMoney) / (double)bettingMoney * 100);
    }

    @Override
    public String toString() {
        return lottos.stream().map(Object::toString).collect(Collectors.joining("\n"));
    }

}
