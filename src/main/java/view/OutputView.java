package view;

public class OutputView {
    public static void printCountOfWinLotto(int[] winCounts, int retRate){
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + winCounts[2]);
        System.out.println("4개 일치 (50000원) - " + winCounts[3]);
        System.out.println("5개 일치 (1500000원) -  " + winCounts[4]);
        System.out.println("6개 일치 (2000000000원) - " + winCounts[5]);
        System.out.println("당신의 수익률은 " + retRate + "%입니다.");
    }
}
