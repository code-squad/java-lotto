import java.util.ArrayList;

public class Decision {
    public void addRank(Lotto rightNum, ArrayList<Lotto> lottos, String bonusNum) {
        for(int i = 0; i < lottos.size(); i++) {
            deliverCount(lottos.get(i), rightNum, bonusNum);
        }

        for (int i = 0; i < lottos.size(); i++)
            decisionRank(lottos.get(i), deliverCount(lottos.get(i), rightNum, bonusNum), bonusNum);
    }

    public Integer deliverCount(Lotto lotto, Lotto rightNum, String bonusNum) {
        int count = 0;
        for(int i = 0; i < rightNum.getRight().size(); i++) {
            if(lotto.getLotto().contains(Integer.parseInt(rightNum.getRight().get(i)))) {
                count++;
            }
        }
        return count;
    }

    public ArrayList<Rank> decisionRank(Lotto lotto ,int count, String bonusNum) {
        ArrayList<Rank> ranks = new ArrayList<>();
        if(count > 2 && (!lotto.getLotto().contains(Integer.parseInt(bonusNum))))
            ranks.add(Rank.valueOf(count, false));

        if(count == 5 && lotto.getLotto().contains(Integer.parseInt(bonusNum)))
            ranks.add(Rank.valueOf(5, true));
        return ranks;
    }
}

