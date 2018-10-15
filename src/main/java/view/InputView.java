package view;

import java.util.Scanner;

public class InputView {
    public static Scanner sc = new Scanner(System.in);
    public static int inputCount(){
        System.out.println("구입금액을 입력해주세요.");
        return sc.nextInt() / 1000;
    }
}
