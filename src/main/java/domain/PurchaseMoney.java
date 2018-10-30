package domain;

import util.Parser;

public class PurchaseMoney {
    /* 피드백 2-1) Money 객체를 추상화하는 것이 어떨까? */
    /* 구매비용에 대해 PurchaseMoney 객체 생성과 int 형 관리 비교
       1. 예외처리 위치!
        - int 타입으로 관리했을 때는, InputView에서 입력을 받았을 경우, 예외처리를 수행
          (1000원 미만 입력할 경우, 비용보다 수동구매의 수가 많을 경우)
        - 클래스를 통해 관리할 경우에는 객체를 생성하는 과정에서 예외처리를 수행
            --> 최종적으로 PurchaseMoney객체에서 예외처리를 담당하기 때문에 다른 도메인에서 생성자를 통해 접근했을 떄도 예외처리 가 가능하다!

       2. 메소드의 분리
        - 로또 구매에 대한 메소드와 로또 구매, 로또 결과를 저장하여 Dto 생성에 관한 모든 메소드들이 LottoGame 클래스에서 관리
            --> LottoGame 클래스에서 많은 기능을 담당
        - 로또 구매에 대한 처리를 위한 메소드는 PurchaseMoney, 로또 결과를 처리하는 메소드는 RewardMoney로 관리하려 처리
    */
    public static int LOTTO_PRICE = 1000;
    private int purchasePay;

    public PurchaseMoney(String purchasePay) {
        /* 구매금액이 1000원 미만 또는 숫자 입력할 경우 예외 발생 */
        if(Parser.parseInteger(purchasePay) < LOTTO_PRICE) {
            throw new ShortPurchaseMoneyException("1000원 미만은 구매할 수 없습니다.");
        }
        this.purchasePay = Parser.parseInteger(purchasePay);
    }

    public int obtainHandOperatedCount(String handOperated) {
        /* 구매금액을 초과해서 수동구매를 했을 경우 예외 발생 */
        if(purchasePay < Integer.parseInt(handOperated) * LOTTO_PRICE) {
            throw new ShortPurchaseMoneyException("구입한 금액보다 더 많이 구매할 수 없습니다.");
        }
        return Integer.parseInt(handOperated);
    }

    /* 가격에 맞게 구매할 수 있는 로또 갯수 구하는 메소드 */
    public int countGame(int handOperatedNum) {
        return (purchasePay / PurchaseMoney.LOTTO_PRICE) - handOperatedNum;
    }
}
