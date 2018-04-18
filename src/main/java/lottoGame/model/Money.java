package lottoGame.model;

public class Money {

    private static final int LOTTOPRICE = 1000;

    public static int getLottoCnt(int money) {
        return money/LOTTOPRICE;
    }

    public static String getLottoProfitPer(int reward, int money) {
        String profitPer = String.format("%.0f", ((float)reward/money)*100);
        return profitPer;
    }
}

