import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {
        Input input = new Input();
        int inputPrice = InputPrice.inputPrice();
        int handbuy = Handbuy.handBuy();

        System.out.println("수동으로" + handbuy + "장, 자동으로 " + ((inputPrice / 1000) - handbuy) + "개를 구매했습니다.");
        ArrayList<Lotto> lottos = input.makeLottos(((inputPrice / 1000) - handbuy));
        Input.rightNumber();
        Check check = new Check();
        check.checking(lottos);
        String bonusNum = BonusNum.bonusNum();
        Input.rightResult();
        Money money = new Money();
        Decision decision = new Decision();
        decision.addRank(check.getRight(), lottos, bonusNum);
        money.money(decision.decisionRank(lottos, check.getRight() , bonusNum));
        ResultView.printCount(money.finalCount);
        ResultView.printResult(lottos, bonusNum, inputPrice, check.getRight());
        System.out.println("수동구매 연습");
        HandLotto hand = new HandLotto();
        hand.generateHandLotto(handbuy, lottos);
        hand.printLottoAll(lottos);
    }
}
