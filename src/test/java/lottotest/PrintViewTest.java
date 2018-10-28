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
        int[] intArr = {1, 2, 3, 4, 5, 6, 7};
        String[] strArr = {"1", "2", "3", "4", "5", "6", "7"};

        List<Integer> intList = new ArrayList(Arrays.asList(intArr));
        List<String> strList = new ArrayList<>(Arrays.asList(strArr));

        System.out.println(intList);    // 정수배열을 리스트로 바꾸고 출력하면 주소값을 반환
        System.out.println(strList);    //   문자열을 리스트로 바꾸고 출력하면 값을 반환
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
