package lotto;

import dto.LottoDto;
import org.junit.Test;
import vo.Num;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void FromListToSet() {
//        Num[] num = {};
        List<Num> list = new ArrayList<>(Arrays.asList(new Num(1),new Num(3),new Num(5),new Num(7)));
//        for (Num num1 : num) {
//            list.add(num1);
//        }

        List<Num> list2 = new ArrayList<>(list);
        List<Num> list3 = new ArrayList<>(list);
        assertThat(list2).isEqualTo(list3);
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
        List<Num> a ;
        a = Arrays.asList(new Num(1),new Num(2),new Num(3),new Num(4));                        // 얕은복사
        a = new ArrayList<>(Arrays.asList(new Num(1),new Num(2),new Num(3),new Num(4)));       // 깊은복사
        List<Num> b = new ArrayList<>(a);
        List<Num> c = new ArrayList<>(a);
        System.out.println(b.contains(a.get(0)));   // set contains 메서드는 원하는 결과가 안나온다.
    }
}
