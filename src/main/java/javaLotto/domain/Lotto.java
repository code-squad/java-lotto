package javaLotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<List<Integer>> lottos = new ArrayList<>();


    public Lotto(List<List<Integer>> lotto)throws Exception {
        this.lottos = lotto;
    }

    public  List<List<Integer>> getLottos() {
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
