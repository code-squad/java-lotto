import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        ArrayList<Lotto> lottos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해주세요.");
        int inputPrice = scanner.nextInt();
        int num = inputPrice / 1000;
        System.out.println(num + "개를 구매했습니다.");

        for(int i = 0; i < num; i++) {
            Lotto lotto = new Lotto();
            lotto.printLotto();
        }
        
        System.out.println();
        System.out.println("지난주의 당첨번호를 입력해주세요.");
        String rightInput = scanner.next();
        List<String> div = Arrays.asList(rightInput.split(","));

    }
}
