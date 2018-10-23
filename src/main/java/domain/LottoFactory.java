package domain;

import util.LottoException;
import view.InputView;
import java.util.*;
import java.util.regex.Pattern;

public class LottoFactory {
    public static final String SPLIT_STANDARD = ", ";

    /* 로또 생성하는 메소드 */
    public static Lotto createLotto() {
        return new Lotto(shuffle().subList(0, Lotto.LOTTO_NUMBER_COUNT));
    }

    /* 당첨번호 로또 생성하는 메소드 */
    public static Lotto createLotto(String lottoString) {
        /* [피드백1] */
        /* 로또의 유효성을 체크하는 내용은 Lotto 클래스에서 처리하는 것을 권장
        *    --> Lotto 객체를 생성하는 방법은 2가지이다! 하나는, 팩토리의 create()메소드, 하나는 Lotto 생샹자를 통해 구현 가능
        *    --> 하지만! 결국은! Lotto 생성자를 통해 최종적으로 생성된다! 그렇기 때문에 Lotto 생성자에서 유효성 체크!
        *    --> 만약, 팩토리를 통해서만 Lotto객체를 생성하도록 하려고 한다면, Lotto 생성자의 접근제한자를 Default로 사용! */
        if(!isValidFormat(lottoString)) {
            try {
                throw new LottoException("유효하지않는 형식의 당첨번호를 입력하셨습니다.");
            } catch (LottoException lottoException) {
                return InputView.getWinningNum();
            }
        }
        return new Lotto(createWinningLottoNumbers(lottoString));
    }

    /* 당첨결과 문자열을 쪼개는 메소드 */
    private static List<LottoNum> createWinningLottoNumbers(String input) {
        List<LottoNum> lottoNums = new ArrayList<>();
        for(String split : input.split(SPLIT_STANDARD)) {
            lottoNums.add(new LottoNum(Integer.parseInt(split)));
        }
        return lottoNums;
    }

    /* 입력형식에 맞게 입력되었는지 확인하는 메소드 */
    private static boolean isValidFormat(String input) {
        String regex = "[0-9]{1,2}, [0-9]{1,2}, [0-9]{1,2}, [0-9]{1,2}, [0-9]{1,2}, [0-9]{1,2}";
        if(!Pattern.compile(regex).matcher(input).find()) {
            return false;
        }
        return true;
    }

    /* 난수 발생 메소드 */
    private static List<LottoNum> shuffle() {
        List<LottoNum> shuffles = new ArrayList<>();
        for(int i = 1; i <= LottoNum.LOTTO_MAX; i++) {
            shuffles.add(new LottoNum(i));
        }
        Collections.shuffle(shuffles);
        return shuffles;
    }
}
