package lottotest;

import org.junit.Test;
import vo.Num;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void shuffleTest() {
        List<Integer> list = new ArrayList<>(Arrays.asList(13, 15, 17, 19, 20, 43));
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
        List<Integer> list1 = new ArrayList<>(Arrays.asList(4, 5, 8, 9, 10, 11, 15, 14));
        System.out.println(list1);

        List<Integer> list2 = new ArrayList<>(Arrays.asList(4, 5, 8, 9, 10, 11, 15, 14));
        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i) + " ");
        }
    }

    @Test
    public void string배열을리스트에넣기() {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        System.out.println(list);
    }

    @Test
    public void userMatchWinning() {
        List<Num> list = new ArrayList<>(Arrays.asList(new Num(3),new Num(5),new Num(4),new Num(6)));

        Set<Num> user = new TreeSet<>(list);        //리스트를 set에 담기 (제네릭 일치해야함)
        Set<Num> win = new TreeSet<>(user);

        System.out.println(list);
        System.out.println(win);

        assertThat(((TreeSet<Num>) win).pollFirst()).isEqualTo(list.get(0));
    }
}
