import java.util.Scanner;

public class HandLotto {
    public static void generateHandLotto(int handbuy) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for(int i = 0; i < handbuy; i++) {
            String str = scanner.nextLine();
            System.out.println(i + "번째 " + str);
        }
    }
}
