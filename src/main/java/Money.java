import java.util.ArrayList;

public class Money {
    static ArrayList<Integer> totalMoney = new ArrayList<>();

    public ArrayList<Integer> money(ArrayList<Integer> counts) {
        for(int i = 0; i < counts.size(); i++) {
            int num = 0;
            if(counts.get(i) == 3) {
                num++;
                System.out.println("3개 일치 (5000원)- " + num);
                totalMoney.add(5000);
            }

            if(counts.get(i) == 4) {
                num++;
                System.out.println("4개 일치 (50000원)- " + num);
                totalMoney.add(50000);
            }

            if(counts.get(i) == 5) {
                num++;
                System.out.println("5개 일치 (1500000원)- " + num);
                totalMoney.add(1500000);
            }

            if(counts.get(i) == 6) {
                num++;
                System.out.println("6개 일치 (2000000000원)- " + num);
                totalMoney.add(2000000000);
            }
        }
        return totalMoney;
    }

    public Integer totalMoney(ArrayList<Integer> totalMoney) {
        int sum = 0;
        for(int i = 0; i < totalMoney.size(); i++)
            sum += totalMoney.get(i);
        return sum;
    }

    public Integer profit(int profit, int output) {
        return (profit / output) * 100;
    }
}
