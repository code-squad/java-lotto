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

        Rank(int countOfMatch, int winningMoney) {
            this.countOfMatch = countOfMatch;
            this.winningMoney = winningMoney;
        }

        public int getCountOfMatch() {
            return countOfMatch;
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

    public LottoGame(int totalCount, List<String> userLottoText){
        lottos = new ArrayList<Lotto>();
        int autoLottoCount = totalCount - userLottoText.size();
        int manualLottoCount = userLottoText.size();
        getManualLottos(userLottoText);
        getAutoLottos(autoLottoCount);
        OutputView.printMyLotto(lottos, manualLottoCount, autoLottoCount);
    }

    private void getAutoLottos(int autoLottoCount) {
        for (int i = 0; i < autoLottoCount; i++) {
            lottos.add(new Lotto());
        }
    }

    private void getManualLottos(List<String> userLottoText) {
        for (int i = 0; i < userLottoText.size(); i++){
            lottos.add(new Lotto(generateLottoNum(userLottoText.get(i))));
        }
    }

    public static int amountOfLotto(int money) {
        return money/PRICE;
    }

    public List<Integer> generateLottoNum(String luckyNumText) {
        List<Integer> luckNum = new ArrayList<>();
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
        WinningLotto winningLotto = new WinningLotto(generateLottoNum(luckyNumText), bonusNumber);
        Map<Rank, Integer> result = initResult();

        for(Lotto lotto : lottos){
            boolean bonusYn = false;
            int key = lotto.countMatchLotto(winningLotto);
            bonusYn = isBonusYn(winningLotto, lotto, bonusYn, key);

            result = replace(result, Rank.valueOf(key, bonusYn));
        }

        return new LottoResult(result, calRetRate(result, lottos.size()*PRICE));
    }

    private HashMap<Rank, Integer> initResult() {
        return new HashMap<Rank, Integer>(){
            {
                put(Rank.FIRST, 0);
                put(Rank.SECOND, 0);
                put(Rank.THIRD, 0);
                put(Rank.FOURTH, 0);
                put(Rank.FIFTH, 0);
            }
        };
    }

    private boolean isBonusYn(WinningLotto winningLotto, Lotto lotto, boolean bonusYn, int key) {
        if(key >= 5){
            bonusYn = lotto.hasBonus(winningLotto);
        }
        return bonusYn;
    }

    // private 객체에 대한 테스트 방법
    // 1. 코드를 수정하지 않고 하려면 private을 public 메소드로 바꾸고 테스트를 진행한다.
    // 2. 해당 메소드가 현재 클래스의 private 메소드가 맞는지 의심해봐야 한다.
    // -> 해당 메소드에 파라미터들을 객체로 만들고 이 내부에 메소드를 public 메소드로 들어가야하는 것이 아닌지에 대해 의심해봐야한다.
    public Map<Rank, Integer> replace(Map<Rank, Integer> result, Rank key) {
        if(result.containsKey(key)){
            int targetCount = result.get(key);
            result.replace(key, targetCount, targetCount+1);
        }
        return result;
    }

    //


}
