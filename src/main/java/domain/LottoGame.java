package domain;

import dto.LottoResult;
import utils.ParsingUtils;
import utils.StringUtils;
import view.OutputView;

import java.util.*;

public class LottoGame {
    private List<Lotto> lottos;
    public static final int PRICE = 1000;
    public static final int THREE = 5000;
    public static final int FOUR = 50000;
    public static final int FIVE = 1500000;
    public static final int SIX = 2000000000;


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

    public int calRetRate(Map<Integer, Integer> result, int money) {
        return (int)(((double)(result.get(3)*THREE+result.get(4)*FOUR+result.get(5)*FIVE+result.get(6)*SIX-money))/money*100);
    }

    public LottoResult match(String luckyNumText, int bonusNumber) {
        List<Integer> luckyNum = generateLuckyNum(luckyNumText);
        Map<Integer, Integer> result = new HashMap<Integer, Integer>(){
            {
                put(3, 0);
                put(4, 0);
                put(5, 0);
                put(6, 0);
            }
        };

        for(Lotto lotto : lottos){
            int key = lotto.countMatchLotto(luckyNum);
            result = replace(result, key);
        }

        return new LottoResult(result, calRetRate(result, lottos.size()*PRICE));
    }

    public Map<Integer,Integer> replace(Map<Integer, Integer> result, int key) {
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
