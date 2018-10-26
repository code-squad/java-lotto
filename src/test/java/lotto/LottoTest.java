package lotto;

import dto.LottoDto;
import org.junit.Test;
import vo.Num;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void FromListToSet() {
        List<Num> list = new ArrayList<>();
        list.add(new Num(1));
        list.add(new Num(3));
        list.add(new Num(6));
        list.add(new Num(8));

        List<Num> list2 = new ArrayList<>(list);
        List<Num> list3 = new ArrayList<>(list);
//        System.out.println(set);
//        System.out.println(((TreeSet<Num>) set).pollFirst());
//        System.out.println(set.size());
        System.out.println(list2.contains(list3.get(0)));
    }

    @Test
    public void mapForEachTest() {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,100);
        map.put(2,200);
        map.put(3,300);
        map.put(4,400);
        for (Integer integer : map.keySet()) {
            System.out.println(integer);
        }
    }

    @Test
    public void matchNumTest() {
        UserLotto userLotto = new UserLotto(3);
        for (LottoDto lottodto : userLotto.toDto().getUserLottoDto()) {
            System.out.println(lottodto);
        }
        String[] num = {"10","20","24","25","16","30"};
        Lotto lotto = new WinningLotto(num).makeWinningLotto();
        System.out.println(userLotto.toDto().getUserLottoDto().contains(lotto.toDto()));
    }

    @Test
    public void setContainTest() {
        List<Num> a = new ArrayList<>();
        a.add(new Num(1));
        a.add(new Num(2));
        a.add(new Num(3));
        a.add(new Num(4));

        List<Num> b = new ArrayList<>(a);
        List<Num> c = new ArrayList<>(a);

        System.out.println(b.contains(a.get(0)));   // set contains 메서드는 원하는 결과가 안나온다.
    }
}
