package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoStore {

    private List<Lotto> lottos = new ArrayList<>();
    private List<Integer> winners = new ArrayList<>();

    public LottoStore(int money) {
        if (money % 1000 != 0 || money < 1000 || money > 1000000000) {
            throw new IllegalArgumentException();
        }
        int count = money / 1000;
        while (count > 0) {
            lottos.add(new Lotto());
            count--;
        }
    }

    public LottoStore(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public LottoResult match(String winNumbers) {
        winners = Arrays.stream(winNumbers.split(",")).map(i -> Integer.parseInt(i)).collect(Collectors.toList());
        if (winners.size() != 6) {
            throw new IllegalArgumentException();
        }
        return new LottoResult(this);
    }

    public Map<PriceType, Integer> getStatistics() {
        Map<PriceType, Integer> statistics = new HashMap<>();
        statistics.put(PriceType.FORTH, 0);
        statistics.put(PriceType.THIRD, 0);
        statistics.put(PriceType.SECOND, 0);
        statistics.put(PriceType.FIRST, 0);

        for (Lotto lotto : this.lottos) {
            int count = lotto.getResult(winners).size();
            if (count > 2) {
                int value = statistics.get(PriceType.getPriceType(count))+1;
                statistics.put(PriceType.getPriceType(count), value);
            }
        }
        return statistics;
    }
}
