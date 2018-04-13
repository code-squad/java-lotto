package LottoGame.view;

import LottoGame.LottoGame;
import LottoGame.Lottos;
import LottoGame.WinningLotto;
import LottoGame.Result;
import LottoGame.LottoNo;
import LottoGameUtil.LottoUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Scanner;

/**
 * Created by hongjong-wan on 2018. 4. 8..
 */
@Slf4j
public class ConsoleMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /**
         * [ 질문 ]
         *
         * 예외 처리 또한 한곳에서 처리해야 중복을 제거할 수 있기 때문에
         * 컨트롤러역할을 하는 메인 메소드에서 일괄 처리했습니다.
         *
         * 그런데 여기서 질문이 있습니다.
         * 웹에서는 파라미터로 넘어온 값에 대해 컨트롤러에서 모두 벨리데이션 체크를 해주는데
         *
         * 여기서는 호출하는 메소드내에서 벨리데이션 체크를해주는 경우 굳이 메인메소드에서 벨리데이션 체크를하지않고
         * 메소드내에서 벨리데이션 체크하도록 놔두고 있습니다.
         * 그렇지 않은 경우만 벨리데이션 체크를 해주고 있습니다.
         *
         * 이러한 방식은 웹에서는 좋은 방식이 아닌거죠?
         */
        try {
            int money = ConsoleInputView.getMoney(sc);
            int lottoTicketNumber = LottoUtils.getLottoTicketNumber(money);

            int manualLottoCount = ConsoleInputView.getManualLottoCount(sc);
            if(manualLottoCount < 0) {
                throw new IllegalArgumentException("수동으로 구매할 로또 수는 양수만 입력이 가능합니다.");
            }
            int autoLottoCount = lottoTicketNumber - manualLottoCount;
            LottoGame lottoGame = new LottoGame();
            for (int i = 0; i < manualLottoCount; i++) {
                /**
                 * [ 질문 ]
                 *
                 * 수동으로 구매할 번호를 입력해 주세요." 문구가 아래 예시처럼 수동으로 구매할 로또 수만큼 출력되는데 크게 상관없겠죠?
                 * 그렇다고 해당 문구를 for문 밖으로 빼거나 문구만 담당하는 함수를 ConsoleInputView 에 별도로 만드는것은
                 * 비효율적인것 같아서요
                 *
                 * ex)
                 *      수동으로 구매할 로또 수를 입력해 주세요.
                 *      2
                 *      수동으로 구매할 번호를 입력해 주세요.
                 *      1,2,3,4,5,6
                 *      수동으로 구매할 번호를 입력해 주세요.
                 *      2,3,4,5,6,7
                 */
                lottoGame.createManualLotto(ConsoleInputView.getManualLottoNumber(sc));
            }
            lottoGame.createAutoLotto(autoLottoCount);
            ConsoleResultView.printPurchaseNumber(manualLottoCount, autoLottoCount);

            Lottos lottos = lottoGame.getLottos();
            ConsoleResultView.printLottos(lottos);

            String winningNumber = ConsoleInputView.getWinningNumber(sc);
            if(StringUtils.isBlank(winningNumber)) {
                throw new IllegalArgumentException("지난 주 당첨번호를 입력해주세요.");
            }

            WinningLotto winningLotto = new WinningLotto(
                    winningNumber,
                    new LottoNo(ConsoleInputView.getBonusNumber(sc)));

            List<Result> results = lottoGame.getRankResults(winningLotto);
            int yield = lottoGame.getYield(results, money);
            ConsoleResultView.printResult(results, yield);
        } catch (NumberFormatException e) {
            log.error("숫자를 입력해주세요.");
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage());
        }

    }
}