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
        int[] fss = {1, 1, 2, 3, 2, 3};
        Set<Integer> tr = new HashSet<>(Arrays.hashCode(fss));
        System.out.println(tr);
    }

    @Test
    public void int배열을리스트에넣기() {
        int[] num = {4, 5, 8, 9, 10, 11, 15, 14};
        List<Integer> list1 = new ArrayList<>();
        for (int i : num) {
            list1.add(i);
        }
        System.out.println(list1);

        List<int[]> list2 = new ArrayList<>(Arrays.asList(num));
        for (int i = 0; i < list2.get(0).length; i++) {
            System.out.print(list2.get(0)[i]);
        }
        System.out.println();
    }
            //Arrays.asList는 string배열만 가능
    @Test
    public void string배열을리스트에넣기() {
        String[] asdf = {"a", "b", "c", "d"};
        List<String> list = new ArrayList<>(Arrays.asList(asdf));
        System.out.println(list);
    }

    @Test
    public void userMatchWinning() {
        Num[] num = {new Num(3),new Num(4),new Num(5),new Num(6)};
        List<Num> list = new ArrayList<>(Arrays.asList(num));

        Set<Num> user = new TreeSet<>(list);
        Set<Num> win = new TreeSet<>(user);

        assertThat(((TreeSet<Num>) win).pollFirst()).isEqualTo(list.get(0));
    }
}
