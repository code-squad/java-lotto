package lotto.domain;

import lotto.dto.WinningDTO;
import lotto.type.WinningType;

import java.util.*;
import java.util.stream.Stream;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public boolean add(Lotto lotto){
        return lottos.add(lotto);
    }

    public int size(){
        return lottos.size();
    }

    public Stream<Lotto> stream(){
        return lottos.stream();
    }

    public WinningDTO match(WinningLotto wLotto) {
        WinningDTO result = new WinningDTO(getTotalCost());
        for(Lotto lotto : lottos){
            result.update(matchLotto(wLotto, lotto));
        }

        return result;
    }

    public WinningType matchLotto(WinningLotto wLotto, Lotto lotto){
        return WinningType.parse(wLotto.match(lotto), wLotto.isBonus(lotto));
    }

    public int getTotalCost(){
        return lottos.size() * Lotto.COST;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lottos)) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lottos);
    }

    @Override
    public String toString() {
        return lottos.toString();
    }
}
