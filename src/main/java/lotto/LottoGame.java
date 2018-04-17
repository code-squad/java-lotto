package lotto;

import java.util.*;

/**
 * 로또 1단계
 *
 * 요구사항
 * 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
 * 로또 1장의 가격은 1000원 이다.
 * 모든 기능을 TDD 로 구현해 단위 테스트가 존재해야한다. 단 UI(System.out, System.in) 로직은 제외
 *
 * 힌트
 * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
 * UI 로직을 InputView, ResultView 와 같은 클래스를 추가해 분리한다.
 * 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
 * Collections.sort() 메소드를 활용해 정렬 가능하다.
 * ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.
 *
*/
// 랜덤 숫자 구하기는 Math.random() 함수를 사용하거나 Collections.suffle() 함수를 사용
public class LottoGame {
    private static final int LOTTO_PRICE = 1_000;

    public static void main(String[] args) {
        System.out.println("구입 금액을 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();             // 구입 금액
        int lottoCount = money / LOTTO_PRICE;      // 구입한 로또 개수
        int winCount = 0;                          // 당첨된 개수

        System.out.println(lottoCount + "개를 구매했습니다.");

        lottoNumbersAdd();
        ArrayList userLottoList = getUserLottoList(lottoCount);

        System.out.println("userLottoList : " + userLottoList);
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        Set set = getWinningNumber(scanner);
        winCount = getWinnningCount(lottoCount, winCount, userLottoList, set);
        resultGame(winCount);
    }

    /* 당첨번호 Set. Set 은 중복을 허용하지 않음 */
    private static Set getWinningNumber(Scanner scanner) {
        Set set = new HashSet();
        for (int i = 0; i < 6; i++) {
            int winningNumber = scanner.nextInt();
            set.add(winningNumber);
        }
        return set;
    }

    /* 구입한 로또 개수만큼 List 담기 */
    private static ArrayList getUserLottoList(int lottoCount) {
        ArrayList userLottoList = new ArrayList();

        for (int i = 1; i <= lottoCount; i++) {
            userLottoList.add(lottoNumbersAdd());
        }
        return userLottoList;
    }

    private static int getWinnningCount(int lottoCount, int winCount, ArrayList userLottoList, Set set) {
        // 당첨 통계
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (int i = 0; i < lottoCount; i++) {
            System.out.println(("1 : " + set.contains(userLottoList.get(i))));
            winCount += (((set.contains(userLottoList.get(i)))) ? 1 : 0);
        }
        return winCount;
    }

    private static void resultGame(int winCount) {
        switch (winCount) {
            case 3:
                System.out.println(winCount + "개 일치 (5000원)-" + "1개");
                break;
            case 4:
                System.out.println(winCount + "개 일치 (50000원)-" + "1개");
                break;
            case 5:
                System.out.println(winCount + "개 일치 (1500000원)-" + "1개");
                break;
            case 6:
                System.out.println(winCount + "개 일치 (2000000000원)-" + "0개");
                break;
            default:
                break;
        }

        // 수익률은 미처 구하지 못했습니다.
    }

    /* 로또 번호 6개 추출하기 */
    private static String lottoNumbersAdd(){
        List<Integer> lottoNum = new ArrayList<>();

        // List 안에 로또 번호 1~45 까지 추가
        for (int i = 1; i <= 45; i++) {
            lottoNum.add(i);
        }

        // Collections.shuffle을 사용해 로또 안의 수를 무작위로 섞는다
        Collections.shuffle(lottoNum);

        // 로또는 6개 번호를 가지므로 로또 1개 int[] 로 생성
        int[] userLotto = new int[6];
        for (int i = 0; i < userLotto.length; i++) {
            userLotto[i] = lottoNum.get(i);
        }

        return Arrays.toString(userLotto);
    }
}