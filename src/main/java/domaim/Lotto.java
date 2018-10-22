package domaim;

import java.util.*;

public class Lotto {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private List<LottoNum> lottos;

    public Lotto(List<LottoNum> lottos) {
        /* protected 할려했는데, 테스트를 위해서는 public 필요! 결국은 public으로 하고 유효성 검사를 하면된다!
         * 질문! String 입력받은건 팩토리, List 입력받은건 Lotto, 객체 생성하는 로직을 다른 클래스로 분리하는건 좋지 않는거죠? */
        if(isDuplicationLottoNumber(lottos)) {
            throw new IllegalArgumentException("중복된 번호를 입력하셨습니다.");
        }
        this.lottos = lottos;
    }

    /* 당첨유무 확인을 위한 번호 체크 메소드 */
    private boolean isContainNumber(LottoNum lottoNum) {
        return lottos.contains(lottoNum);
    }

    /* 로또 번호 가져오는 메소드 */
    public LottoNum getLottoNum(int index) {
        return lottos.get(index);
    }

    /* 당첨번호에 중복된 번호가 있는지 확인하는 메소드 --> 현재 사용하지 않지만, 일단 Hold */
    private static boolean isDuplicationLottoNumber(List<LottoNum> lottoNums) {
        if(new HashSet<LottoNum>(lottoNums).size() < Lotto.LOTTO_NUMBER_COUNT) {
            return true;
        }
        return false;
    }

    /* 로또 번호가 맞는지 확인하는 메소드
     *    --> 포함할때만 더하는 경우이기 때문에.. 2depth가 존재...  */
    public int matchLotto(Lotto winningLotto) {
        int cnt = 0;
        for(int i = 0; i < Lotto.LOTTO_NUMBER_COUNT; i++) {
            cnt = isContainNumber(winningLotto.getLottoNum(i)) ? cnt + 1 : cnt;
        }
        return cnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lottos, lotto1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
