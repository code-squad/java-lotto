package step1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import step1.LottoResult.MatchKey;

public class LottoGame {

  private static final int LOTTO_NUM_COUNT = 6;

  public int getLottoGameNum(String money) {
    return Integer.parseInt(money) / 1000;
  }

  public int countSameNum(Lotto jackpot, Lotto input) {
    List<Integer> notSameNum = input.getNums();
    notSameNum.removeAll(jackpot.getNums());

    return LOTTO_NUM_COUNT - notSameNum.size();
  }


  public LottoResult match(Lotto jackpot, Lottos lottos) {
    Map<String,Integer> result = new HashMap<>();

    for(Lotto l : lottos.getLottos()){
      if(countSameNum(jackpot,l) == 3){
        result.put(MatchKey.MATCH_3NUM_KEY, result.getOrDefault(MatchKey.MATCH_3NUM_KEY, 0) + 1);
      }else if(countSameNum(jackpot,l) == 4){
        result.put(MatchKey.MATCH_4NUM_KEY, result.getOrDefault(MatchKey.MATCH_4NUM_KEY, 0) + 1);
      }else if(countSameNum(jackpot,l) == 5){
        result.put(MatchKey.MATCH_5NUM_KEY, result.getOrDefault(MatchKey.MATCH_5NUM_KEY, 0) + 1);
      }else if(countSameNum(jackpot,l) == 6){
        result.put(MatchKey.MATCH_6NUM_KEY, result.getOrDefault(MatchKey.MATCH_6NUM_KEY, 0) + 1);
      }
    }

    System.out.println(result.toString());

    return new LottoResult(result);
  }
}
