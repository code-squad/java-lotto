package lotttoOlder.view;

import java.util.Map;
import lotttoOlder.LottoInfo;
import lotttoOlder.LottoResult;
import lotttoOlder.Lottos;

public class OutputView {
  public static void printPurchaseInfo(int lottoNum) {
    System.out.println(lottoNum + "개를 구매했습니다.");
  }

//  TODO 객체말고 실제 넘버 넘기기
  public static void printLottosNum(Lottos lottos,String delimiter) {
    for(String nums: lottos.showNums(delimiter)){
      System.out.println("[" + nums + "]");
    }
  }

  public static void printLottoResult(Map<String,Integer> matchResult, double profitRate){
    System.out.println("  당첨 통계");
    System.out.println("---------");
    for(LottoInfo li : LottoInfo.values()){
      System.out.println(li.getMatchNum()+"개 일치 (" + li.getPrize() + "원)- " + matchResult.get(LottoInfo.FOURTH.getMapKey())+ "개");
    }
    System.out.println("총 수익률은 " + profitRate + "%입니다.");
  }
}
