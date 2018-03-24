import domain.LottoMachine;
import view.InputView;

public class LottoMain {

    public static void main(String[] args) {
        int amount = InputView.getPurchaseAmount();
        LottoMachine machine = LottoMachine.of();

        // TODO : 리턴 타입 지정하고 다음 프로세스 나아가기
        machine.publishLotto(amount);
    }


}