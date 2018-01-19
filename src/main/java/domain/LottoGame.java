package domain;

import dto.LottoResult;
import utils.ParsingUtils;
import utils.StringUtils;
import view.OutputView;

import java.util.*;

public class LottoGame {
    private List<Lotto> lottos;
    public static final int PRICE = 1000;
    public enum Rank {

        FIRST(6, 2000000000),
        SECOND(5, 30000000),
        THIRD(5, 1500000),
        FOURTH(4, 50000),
        FIFTH(3, 5000);

        private int countOfMatch;
        private int winningMoney;

        private Rank(int countOfMatch, int winningMoney) {
            this.countOfMatch = countOfMatch;
            this.winningMoney = winningMoney;
        }

        public int getCountOfMatch() {
            return countOfMatch;
        }

        public int getWinningMoney() {
            return winningMoney;
        }

        public static Rank valueOf(int countOfMatch, boolean matchBonus) {

            for(Rank rank : Rank.values()){
                if(matchBonus && countOfMatch == 5){
                    return Rank.SECOND;
                }
                if(rank.getCountOfMatch() == countOfMatch){
                    return rank;
                }
            }

            return null;
        }
    }

    public LottoGame(int money){
        lottos = new ArrayList<Lotto>();
        int amount = amountOfLotto(money);

        for (int i = 0; i < amount; i++) {
            lottos.add(new Lotto(getLotto()));
        }

        OutputView.printMyLotto(lottos);
    }

    private List<Integer> getLotto() {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i < 46; i++) {
            numbers.add(i);
        }

        List<Integer> lotto = subList(shuffle(numbers));
        return sort(lotto);
    }

    public static int amountOfLotto(int money) {
        return money/PRICE;
    }

    public List<Integer> generateLuckyNum(String luckyNumText) {
        List<Integer> luckNum = new ArrayList<Integer>();
        for(String luckyNum : StringUtils.split(luckyNumText)){
            luckNum.add(ParsingUtils.toInts(luckyNum));
        }
        return luckNum;
    }

    public int calRetRate(Map<Rank, Integer> result, int money) {
        double rate = 1.0;
        for(Rank key : result.keySet()){
            rate *= ((double)key.getCountOfMatch()*(double)key.winningMoney);
        }
        return (int)rate;
    }

    public LottoResult match(String luckyNumText, int bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(generateLuckyNum(luckyNumText), bonusNumber);
        Map<Rank, Integer> result = new HashMap<Rank, Integer>(){
            {
                put(Rank.FIRST, 0);
                put(Rank.SECOND, 0);
                put(Rank.THIRD, 0);
                put(Rank.FOURTH, 0);
                put(Rank.FIFTH, 0);
            }
        };

        for(Lotto lotto : lottos){
            boolean bonusYn = false;
            int key = lotto.countMatchLotto(winningLotto);
            if(key >= 5){
                bonusYn = lotto.hasBonus(winningLotto);
            }

            result = replace(result, Rank.valueOf(key, bonusYn));
        }

        return new LottoResult(result, calRetRate(result, lottos.size()*PRICE));
    }

    public Map<Rank, Integer> replace(Map<Rank, Integer> result, Rank key) {
        if(result.containsKey(key)){
            int targetCount = result.get(key);
            result.replace(key, targetCount, targetCount+1);
        }
        return result;
    }

    //
    private List<Integer> subList(List<Integer> numbers) {
        return numbers.subList(0, 6);
    }

    private List<Integer> sort(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    private List<Integer>shuffle(List<Integer> numbers) {
        Collections.shuffle(numbers);
        return numbers;
    }

}
