package domaim;

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

    /* 당첨번호에 중복된 번호가 있는지 확인하는 메소드 --> 현재 사용하지 않지만, 일단 Hold */
    public static boolean isDuplicationLottoNumber(List<LottoNum> lottoNums) {
        if(new HashSet<LottoNum>(lottoNums).size() < Lotto.LOTTO_NUMBER_COUNT) {
            return true;
        }
        return false;
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
