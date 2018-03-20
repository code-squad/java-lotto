import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Decision {
    String bonus = "1";
    static ArrayList<Rank> ranks = new ArrayList<>();

    public ArrayList<Rank> decisionRank(List<String> rightNum, Lotto lotto) {
        printLotto(lotto);
        int count = 0;
        for(int i = 0; i < rightNum.size(); i++) {
            if(lotto.getLotto().contains(Integer.parseInt(rightNum.get(i)))){
                count++;
                ranks.add(compareRank(lotto, count));
            }
        }
        return ranks;
    }

    public Rank compareRank(Lotto lotto, int count) {
        if(count == 5 && lotto.getLotto().contains()) {
            System.out.println("second");
            return Rank.SECOND;
        }
        System.out.println("count is " + count);
        return Rank.valueOf(count, false);
        }

    public void printLotto(Lotto lotto) {
        for(int i = 0; i < lotto.getLotto().size(); i++)
            System.out.print(lotto.getLotto().get(i) + " ");
        System.out.println();
    }
}
