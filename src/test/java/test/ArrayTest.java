package test;

import org.junit.Test;

public class ArrayTest {
    @Test
    public void test(){
        int[] arr1 = {1,2,3};
        int[] arr2 = arr1;
        System.out.println(arr2);
        System.out.println(arr2[0]);
        System.out.println(arr2[1]);
        System.out.println(arr2[2]);
    }
}
