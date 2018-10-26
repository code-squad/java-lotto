package lottotest;

import lotto.Lotto;
import org.junit.Test;
import view.InputView;
import vo.Num;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void shuffleTest() {
        int[] ab = {13, 15, 17, 19, 20, 43};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ab.length; i++) {
            list.add(ab[i]);
        }
//        List<Integer> list = new ArrayList(Arrays.asList(ab));
        Collections.shuffle(list);
        System.out.println(list);
    }

    @Test
    public void treeSetTest() {
        Set<Integer> tr = new TreeSet<>();
        tr.add(1);
        tr.add(1);
        tr.add(2);
        tr.add(3);
        tr.add(3);
        System.out.println(tr);
    }

    @Test
    public void arrayListContainTest() {
        int[] num = {4, 5, 8, 9, 10, 11, 15, 14};
        List<Integer> list1 = new ArrayList(Arrays.asList(num));
        int[] num2 = {4, 5, 8, 9, 10, 11, 15, 14};
        List<Integer> list2 = new ArrayList(Arrays.asList(num2));

        System.out.println(list1.containsAll(list2));
    }

    @Test
    public void fromTreeSetToArrayListTest() {          //TreeSet을 ArrayList에 담음
        TreeSet<String> tree = new TreeSet<>();
        tree.add("a");
        tree.add("y");
        tree.add("c");
        tree.add("z");
        List<String> list3 = new ArrayList<>(tree);
        assertThat(list3.get(2)).isEqualTo(tree.floor(list3.get(2)));
    }

    @Test
    public void userMatchWinning(){


        List<Num> list = new ArrayList<>();
        list.add(new Num(4));
        list.add(new Num(2));
        list.add(new Num(3));
        list.add(new Num(7));

        Set<Num> user = new TreeSet<>(list);


        Set<Num> win = new TreeSet<>();
        win.add(new Num(4));
        win.add(new Num(2));
        win.add(new Num(3));
        win.add(new Num(7));

        System.out.println(user.contains(((TreeSet<Num>) win).pollFirst()));

    }

}
