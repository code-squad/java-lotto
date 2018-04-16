package javaLotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<LottoTicket> lottos;

    public Lotto(List<LottoTicket> lottos){
        this.lottos = lottos;
    }

    public  List<LottoTicket> getLottos() {
        return Collections.unmodifiableList(lottos);
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

    public static void print(Lotto lottos, int manual) {
        System.out.printf("수동으로 %d장 자동으로 %d장 구입했습니다.\n",manual,(lottos.getSize()-manual));
    }
}
