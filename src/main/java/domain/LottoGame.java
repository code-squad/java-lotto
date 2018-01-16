package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private List<Lotto> lottos;
    public static final int PRICE = 1000;

    public LottoGame(int money){
        lottos = new ArrayList<Lotto>();
        int amount = amountOfLotto(money);
        printAmountOfLotto(amount);
        for (int i = 0; i < amount; i++) {
            lottos.add(new Lotto());
        }
        printLottos();
    }

    private void printAmountOfLotto(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    private void printLottos() {
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i).toString());
        }
    }

    public int amountOfLotto(int money) {
        return money/PRICE;
    }

    public int[] compareLotto(String luckyNumText) {
        List<Integer> luckyNum = generateLuckyNum(luckyNumText);
        int[] winCounts = new int[7];
        for(Lotto lotto : lottos){
            winCounts[lotto.countMatchLotto(luckyNum)]++;
        }
        return winCounts;
    }

    private List<Integer> generateLuckyNum(String luckyNumText) {
        List<Integer> luckNum = new ArrayList<Integer>();
        for(String luckyNum : split(luckyNumText)){
            luckNum.add(toInts(luckyNum));
        }
        return luckNum;
    }

    private int toInts(String luckyNum) {
        return Integer.parseInt(luckyNum);
    }

    private String[] split(String luckyNumText) {
        return luckyNumText.split(",");
    }

    public int calRetRate(int[] winCounts, int money) {
        return (int)(((double)(winCounts[2]*5000+winCounts[3]*50000+winCounts[4]*1500000+winCounts[5]*2000000000-money))/money*100);
    }
}

