package domain;

import java.util.Scanner;

public class LottoMain {
    public static int getPurchaseFee() {
        Scanner scanner = new Scanner("10000");
        return scanner.nextInt();
    }

    public static int getTicketCount(int purchaseFee) {
        return purchaseFee / 1000;
    }
}
