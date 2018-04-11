package javaLotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<LottoTicket> lottos;

    public Lotto(List<LottoTicket> lottos)throws Exception {
        this.lottos = lottos;
    }

    public void printLottos() {
        for (LottoTicket lotto : lottos){
            System.out.println(lotto.getLottoTicket());
        }
    }

    public void printLottoSize() {
            System.out.println(lottos.size() + "개를 구입했습니다.");
    }

    public  List<LottoTicket> getLottos() {
        return lottos;
    }
    public int getSize(){
        return lottos.size();
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottos=" + lottos + "\n"+
                '}';
    }
}
