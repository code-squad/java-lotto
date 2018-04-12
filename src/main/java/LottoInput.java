import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LottoInput {
    public static int scanBudget(){
        System.out.print("금액을 적어주세요");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<Integer> scanLuckyNumber(){
        System.out.print("당첨 번호를 적어주세요");
        Scanner scanner = new Scanner(System.in);
        String luckyNumbers = scanner.nextLine();
        String[] names = luckyNumbers.split(",");
        return toInts(Arrays.asList(names));
    }
    private static List<Integer> toInts(List<String> source){
        List<Integer> numbers = new ArrayList<>();
        for (String s: source){
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }

}
