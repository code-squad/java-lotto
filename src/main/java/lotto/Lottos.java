package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public void addLottos(Lottos lottos){
        for(Lotto lotto : lottos.getLottos()){
            this.lottos.add(lotto);
        }
    }

    public int getLottosCount() {
        return lottos.size();
    }

    public Map<Rank,Integer> makeRankCountMap(WinLotto winLotto) {

        Map<Rank, Integer> rankCountMap = new HashMap<>();
        rankCountMap.put(Rank.FIRST, 0);
        rankCountMap.put(Rank.SECOND, 0);
        rankCountMap.put(Rank.THIRD, 0);
        rankCountMap.put(Rank.FOURTH, 0);
        rankCountMap.put(Rank.FIFTH, 0);
        rankCountMap.put(Rank.MISS, 0);

        for(Lotto lotto : lottos){
            Rank rank = lotto.calculateRank(winLotto);
            rankCountMap.put( rank, rankCountMap.get(rank) +1 );
        }
        return rankCountMap;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
