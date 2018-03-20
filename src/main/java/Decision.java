import java.util.ArrayList;
import java.util.List;

public class Decision {
    ArrayList<Rank> ranks = new ArrayList<>();

    public ArrayList<Rank> decisionRank(List<String> rightNum, Lotto lotto, String bonusNum) {
        printLotto(lotto);
        int count = 0;
        for(int i = 0; i < rightNum.size(); i++) {
            if(lotto.getLotto().contains(Integer.parseInt(bonusNum))){
                count++;
                ranks.add(compareRank(lotto, count));
            }
        }
        return ranks;
    }

    public Rank compareRank(Lotto lotto, int count) {
        if(count == 5 && lotto.getLotto().contains(lotto.getLotto().get(5))) {
            System.out.println("second");
            return Rank.SECOND;
        }
        System.out.println(Rank.valueOf(count, false));
        return Rank.valueOf(count, false);
    }

    public void printLotto(Lotto lotto) {
        System.out.print("first lotto is ");
        for(int i = 0; i < lotto.getLotto().size(); i++)
            System.out.print(lotto.getLotto().get(i) + " ");
        System.out.println();
    }

    public void printRanks(ArrayList<Rank> ranks) {
        for(int i = 0; i < ranks.size(); i++)
            System.out.println(ranks.get(i).getCountOfMatch());
    }
}
