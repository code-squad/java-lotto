import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private ArrayList<Integer> numbers = new ArrayList<>();
    private ArrayList<Integer> lotto = new ArrayList<>();
    private ArrayList<Integer> counts = new ArrayList<>();

    public Lotto() {
        for(int i = 0; i < 46; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        for(int i = 0; i < 6; i++) {
            lotto.add(numbers.get(i));
        }
    }

    public void printLotto() {
        for(int i = 0; i < lotto.size(); i++) {
            System.out.print(lotto.get(i) + " ");
        }
    }

    public Integer checkNumber(List<String> rightNum) {
        int count = 0;
        for(int i = 0; i < rightNum.size(); i++) {
            if(lotto.contains(Integer.parseInt(rightNum.get(i))))
                count++;
        }
        counts.add(count);
        System.out.print("count is " + count);
        return count;
    }

    public void money(ArrayList<Integer> counts) {
        for(int i = 0; i < counts.size(); i++) {
            int num = 0;
            if(counts.get(i) == 3) {
                num++;
                System.out.println("3개 일치 (5000원)- " + num);
            }

            if(counts.get(i) == 4) {
                num++;
                System.out.println("4개 일치 (50000원)- " + num);
            }

            if(counts.get(i) == 5) {
                num++;
                System.out.println("5개 일치 (1500000원)- " + num);
            }

            if(counts.get(i) == 6) {
                num++;
                System.out.println("6개 일치 (2000000000원)- " + num);
            }
        }
    }
}
