package lottotest;

import org.junit.Test;

import java.util.*;

public class PrintViewTest {
    @Test
    public void lottoCount() {
        int a = 132300 / 1000;
        System.out.println(a);
    }

    @Override
    public String toString() {
        return "PrintViewTest{}";
    }

    @Test
    public void arraysAsListTest() {
        List<Integer> intList = new ArrayList(Arrays.asList(1, 2, 3, 4,       4,             5, 6, 7));     //공백을 무시한다.
        List<String> strList = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7"));

        System.out.println(intList);
        System.out.println(strList);
    }

    @Test
    public void splitTest() {
        String[] a = {"id", "cid", "refno"};
        String b = "asdf wfda dafwfd fadf";
        String[] c = b.split("\\|");
        for (String s : c) {
            System.out.print(s);
        }
    }
}
