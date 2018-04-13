package step1;

import java.util.ArrayList;
import java.util.List;

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



}
