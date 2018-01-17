package domain;

import java.util.List;

public class Lotto {
    private List<Integer> lotto;

    public Lotto(List<Integer> lotto){
        this.lotto = lotto;

    }

    public int countMatchLotto(List<Integer> luckyNum) {
        int count = 0;
        for(int number : lotto){
            count += matchYn(luckyNum, number);
        }
        return count;
    }

    public static int matchYn(List<Integer> luckyNum, int number) {
        if(luckyNum.contains(number)){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.join(", ", lotto.toString());
    }
}
