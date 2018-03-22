import java.util.ArrayList;
import java.util.List;

public class Decision {
    ArrayList<Rank> ranks = new ArrayList<>();

//    public ArrayList<Rank> addRank(List<String> rightNum, Lotto lotto, String bonusNum) {
////        printLotto(lotto);
//        int count = 0;
//        for(int i = 0; i < rightNum.size(); i++) {
//            if(lotto.getLotto().contains(Integer.parseInt(rightNum.get(i)))){
//                count++;
//                ranks.add(decisionRank(lotto, count, bonusNum));
//            }
//            ranks.add(decisionRank(lotto,count, bonusNum));
//        }
//        return ranks;
//    }

    public ArrayList<Rank> addRank(List<String> rightNum, Lotto lotto, String bonusNum) {
        int count = 0;
        for(int i = 0; i < rightNum.size(); i++) {
            if(lotto.getLotto().contains(Integer.parseInt(rightNum.get(i)))){
                count++;
                ranks.add(decisionRank(lotto, count, bonusNum));
            }
            ranks.add(decisionRank(lotto,count, bonusNum));
        }
        return ranks;
    }

    public Rank decisionRank(Lotto lotto, int count, String bonusNum) {
        if(count == 5 && lotto.getLotto().contains(Integer.parseInt(bonusNum))) {
            System.out.println("Rank is second");
            return Rank.SECOND;
        }
        System.out.println("result is " + Rank.valueOf(count, false));
        return Rank.valueOf(count, false);
    }

    public void printLotto(Lotto lotto) {
        for(int i = 0; i < lotto.getLotto().size(); i++)
            System.out.print(lotto.getLotto().get(i) + " ");
        System.out.println();
    }

    public void printRanks(ArrayList<Rank> ranks) {
        for(int i = 0; i < ranks.size(); i++)
            System.out.println(ranks.get(i).getCountOfMatch());
    }
}

