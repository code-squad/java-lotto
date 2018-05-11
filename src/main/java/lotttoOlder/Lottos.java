package lotttoOlder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

  List<Lotto> lottos;

  public Lottos(int lottoNum) {
    lottos = new ArrayList<>();
    for (int i = 0; i < lottoNum; i++) {
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
    Map<String, Integer> result = new HashMap<>();
    for (Lotto l : lottos) {
      int sameNumCount = l.countSameNumber(jackpot);

      for(LottoInfo li : LottoInfo.values()){
        if(li.getMatchNum() == sameNumCount){
          result.merge(li.getMapKey(),1,Integer::sum);
        }
      }
    }
    return result;
  }

  //TODO change to java8 style
  public List<String> showNums(String delimiter) {
    List<String> nums = new ArrayList<>();
    for(Lotto l : lottos){
      nums.add(l.showNum(delimiter));
    }
    return nums;
  }
}
