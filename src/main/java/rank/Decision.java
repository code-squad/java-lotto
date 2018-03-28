package rank;

import rank.Rank;
import lotto.Lotto;
import java.util.ArrayList;
import java.util.List;

public class Decision {
    public void addRank(Lotto rightNum, List<Lotto> lottos, String bonusNum) {
        for(int i = 0; i < lottos.size(); i++) {
            deliverCount(lottos.get(i), rightNum);
        }

        for (int i = 0; i < lottos.size(); i++)
            decisionRank(lottos, rightNum, bonusNum);
    }

    public Integer deliverCount(Lotto lotto, Lotto rightNum) {
        int count = 0;
        for(int i = 0; i < rightNum.getRight().size(); i++) {
            if(lotto.getLotto().contains(Integer.parseInt(rightNum.getRight().get(i)))) {
                count++;
            }
        }
        return count;
    }

    public List<Rank> decisionRank(List<Lotto> lottos , Lotto rightNum, String bonusNum) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto: lottos) {
            rankLoop(lotto, rightNum, bonusNum, ranks);
        }
        return ranks;
    }

    public void rankLoop (Lotto lotto, Lotto rightNum, String bonusNum, List<Rank> ranks) {
        int count = deliverCount(lotto, rightNum);
        ranks.add(Rank.valueOf(count, containBonus(lotto, bonusNum)));
    }

    public boolean containBonus(Lotto lotto, String bonusNum) {
        return lotto.getLotto().contains(Integer.parseInt(bonusNum));
    }
}

