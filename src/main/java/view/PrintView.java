package view;

import dto.LottoDto;
import dto.UserLottoDto;

import java.util.List;

public class PrintView {
    public static void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }




    public static void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치(5000원)");
        System.out.println("4개 일치(50000원)");
        System.out.println("5개 일치(1500000원)");
        System.out.println("6개 일치(2000000000원)");
    }

    public static void printAutoLotto(UserLottoDto userLottoDto) {
        for (LottoDto lottoDto : userLottoDto.getUserLottoDto()) {
            System.out.println(lottoDto);
        }
    }
}
