package lotto.domain;

import java.util.*;

public class Lotteries implements List<Lotto>{
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
    public boolean contains(Object o) {
        return lotteries.contains(o);
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lotteries.iterator();
    }

    @Override
    public Object[] toArray() {
        return lotteries.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return lotteries.toArray(a);
    }

    @Override
    public boolean add(Lotto lotto) {
        return lotteries.add(lotto);
    }

    @Override
    public boolean remove(Object o) {
        return lotteries.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return lotteries.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Lotto> c) {
        return lotteries.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Lotto> c) {
        return lotteries.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return lotteries.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return lotteries.removeAll(c);
    }

    @Override
    public void clear() {
        lotteries.clear();
    }

    @Override
    public Lotto get(int index) {
        return lotteries.get(index);
    }

    @Override
    public Lotto set(int index, Lotto element) {
        return lotteries.set(index, element);
    }

    @Override
    public void add(int index, Lotto element) {
        lotteries.add(index, element);
    }

    @Override
    public Lotto remove(int index) {
        return lotteries.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return lotteries.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return lotteries.lastIndexOf(o);
    }

    @Override
    public ListIterator<Lotto> listIterator() {
        return lotteries.listIterator();
    }

    @Override
    public ListIterator<Lotto> listIterator(int index) {
        return lotteries.listIterator(index);
    }

    @Override
    public List<Lotto> subList(int fromIndex, int toIndex) {
        return lotteries.subList(fromIndex, toIndex);
    }
}
