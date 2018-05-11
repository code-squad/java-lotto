package lotttoOlder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotttoOlder.LottoResult.MatchKey;

public class Lottos {

  List<Lotto> lottos;

  public Lottos(int lottoNum) {
    lottos = new ArrayList<>();
    for(int i = 0; i < lottoNum; i++){
      lottos.add(new Lotto());
    }
  }

  //테스트용 생성자
  public Lottos(ArrayList<Lotto> lottos) {
    this.lottos = lottos;
  }

  public List<Lotto> getLottos() {
    return lottos;
  }

  public Map<String, Integer> match(Lotto jackpot) {
    Map<String,Integer> result = new HashMap<>();
    for (Lotto l : lottos) {

      new Match() {
        @Override
        public Map<String, Integer> checkMatch(int i) {

          return null;
        }
      };

      //TODO 중복된 것처럼 보이는 코드 고치기? -> enum? 3,MatchKey.MATCH_3NUM_KEY
      if (l.countSameNum(jackpot) == 3) {
        result.put(MatchKey.MATCH_3NUM_KEY, result.getOrDefault(MatchKey.MATCH_3NUM_KEY, 0) + 1);
      } else if (l.countSameNum(jackpot) == 4) {
        result.put(MatchKey.MATCH_4NUM_KEY, result.getOrDefault(MatchKey.MATCH_4NUM_KEY, 0) + 1);
      } else if (l.countSameNum(jackpot) == 5) {
        result.put(MatchKey.MATCH_5NUM_KEY, result.getOrDefault(MatchKey.MATCH_5NUM_KEY, 0) + 1);
      } else if (l.countSameNum(jackpot) == 6) {
        result.put(MatchKey.MATCH_6NUM_KEY, result.getOrDefault(MatchKey.MATCH_6NUM_KEY, 0) + 1);
      }



    }
    return null;
  }


}
