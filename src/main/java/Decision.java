import java.util.ArrayList;
import java.util.List;

public class Decision {
    ArrayList<Rank> ranks = new ArrayList<>();

    public void addRank(List<String> rightNum, ArrayList<Lotto> lottos, String bonusNum) {
        for(int i = 0; i < lottos.size(); i++) {
            deliverCount(lottos.get(i), rightNum, bonusNum);
        }

        for (int i = 0; i < lottos.size(); i++)
            decisionRank(lottos.get(i), deliverCount(lottos.get(i), rightNum, bonusNum), bonusNum);
    }

    public Integer deliverCount(Lotto lotto, List<String> rightNum, String bonusNum) {
        int count = 0;
        for(int i = 0; i < rightNum.size(); i++) {
            if(lotto.getLotto().contains(Integer.parseInt(rightNum.get(i)))) {
                count++;
            }
        }
        return count;
    }

    public ArrayList<Rank> decisionRank(Lotto lotto ,int count, String bonusNum) {
        if(count > 2 && (!lotto.getLotto().contains(Integer.parseInt(bonusNum))))
            ranks.add(Rank.valueOf(count, false));

        if(count == 5 && lotto.getLotto().contains(Integer.parseInt(bonusNum)))
            ranks.add(Rank.valueOf(5, true));
        return ranks;
    }

    public void printRanks() {
        for(int i = 0; i < ranks.size(); i++)
            System.out.println("맞춘갯수 " + ranks.get(i).getCountOfMatch() + " Rank의 값은 :" + ranks.get(i));
        System.out.println("size of ranks is " + ranks.size());
    }
}

