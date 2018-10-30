package domain;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoFactory {
    public static final String SPLIT_STANDARD = ", ";
    private static List<LottoNum> shuffles = new ArrayList<>();
    /* 피드백2-3) LottoNum 인스턴스를 매번 생성해야 하기 때문에 성능이 저하될 가능성 존재 Lotto 인스턴스를 재사용하는 방법이 필요 !!
     *    --> 초기에 모두 생성한 후에, 생성한 객체를 재사용하는 방식 */
    static {
        /* 스트림 변경 전 --> */
        /* for(int i = 1; i < LottoNum.LOTTO_MAX; i++) {
            shuffles.add(new LottoNum(i));
        } */
        IntStream.range(LottoNum.LOTTO_MIN, LottoNum.LOTTO_MAX).forEach(
                (num) -> shuffles.add(new LottoNum(num))
        );
    }

    /* 로또 생성하는 메소드 */
    public static Lotto createLotto() {
        /* 스트림 변경 전 -->  */
        /*List<LottoNum> lotto = new ArrayList<>(shuffle().subList(0, Lotto.LOTTO_NUMBER_COUNT));
        Collections.sort(lotto);
        return new Lotto(lotto);*/
        return new Lotto(shuffle().stream().limit(Lotto.LOTTO_NUMBER_COUNT).sorted().collect(Collectors.toList()));
    }

    /* 수동생성 로또 생성하는 메소드 */
    public static Lotto createHandOperatedLotto(String lottoString) throws InputLottoException {
        if(!isValidFormat(lottoString)) {
            throw new InputLottoException("유효하지않는 형식의 번호를 입력하셨습니다.");
        }
        return new Lotto(createLottoNumbers(lottoString));
    }

    /* 당첨번호 로또 생성하는 메소드 */
    public static WinningLotto createWinningLotto(String lottoString, LottoNum bonusBall) throws InputLottoException {
        if(!isValidFormat(lottoString)) {
            throw new InputLottoException("유효하지않는 형식의 당첨번호를 입력하셨습니다.");
        }
        return new WinningLotto(createLottoNumbers(lottoString), bonusBall);
    }

    /* 당첨결과 문자열을 쪼개는 메소드 */
    public static List<LottoNum> createLottoNumbers(String input) {
        /* 스트림 변경 전 --> */
        /*List<LottoNum> lottoNums = new ArrayList<>();
        for(String split : input.split(SPLIT_STANDARD)) {
            lottoNums.add(new LottoNum(Integer.parseInt(split)));
        }
        return lottoNums;
        */

        return Arrays.stream(input.split(SPLIT_STANDARD))
                .mapToInt(lottoNumString -> Integer.parseInt(lottoNumString))
                .mapToObj(lottoNumber -> new LottoNum(lottoNumber))
                .collect(Collectors.toList());
    }

    /* 입력형식에 맞게 입력되었는지 확인하는 메소드 */
    protected static boolean isValidFormat(String input) {
        String regex = "[0-9]{1,2}, [0-9]{1,2}, [0-9]{1,2}, [0-9]{1,2}, [0-9]{1,2}, [0-9]{1,2}";
        if(!Pattern.compile(regex).matcher(input).find()) {
            return false;
        }
        return true;
    }

    /* 난수 발생 메소드 */
    private static List<LottoNum> shuffle() {
        Collections.shuffle(shuffles);
        return shuffles;
    }
}
