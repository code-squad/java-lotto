import java.util.ArrayList;

public class Money {
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
