package lotto.domain;

import java.util.*;
import java.util.stream.Stream;

public class Lotteries extends ArrayList<Lotto>{
    private List<Lotto> lotteries;

    public Lotteries() {
        lotteries = new ArrayList<>();
    }

    public Lotteries(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    @Override
    public int size() {
        return lotteries.size();
    }

    @Override
    public boolean isEmpty() {
        return lotteries.isEmpty();
    }

    @Override
    public Lotto get(int index) {
        return lotteries.get(index);
    }

    @Override
    public boolean add(Lotto lotto) {
        return lotteries.add(lotto);
    }

    public Lotteries concat(Lotteries lotteries) {
        this.lotteries.addAll(lotteries.lotteries);
        return this;
    }

    @Override
    public Stream<Lotto> stream() {
        return lotteries.stream();
    }

    @Override
    public String toString() {
        return lotteries.toString();
    }
}