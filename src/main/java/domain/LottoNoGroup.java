package domain;

import java.util.List;
import java.util.Objects;

public class LottoNoGroup {

    private List<LottoNo> lottoNos;

    private LottoNoGroup(List<LottoNo> lottoNos) {
        if (!isValidLottoNos(lottoNos)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 입력값 : " + lottoNos.toString());
        }
        this.lottoNos = lottoNos;
    }

    public static LottoNoGroup of(List<LottoNo> lottoNos){
        return new LottoNoGroup(lottoNos);
    }

    static boolean hasDuplication(List<LottoNo> lottoNos) {
        return lottoNos.stream().distinct().count() == (long) lottoNos.size();
    }

    static boolean isValidSize(List<LottoNo> lottoNos) {
        final int VALID_NUMBER_LENGTH = 6;
        return lottoNos.size() == VALID_NUMBER_LENGTH;
    }

    static boolean isValidLottoNos(List<LottoNo> lottoNos) {
        return isValidSize(lottoNos) && hasDuplication(lottoNos);
    }

    public boolean contains(LottoNo bonusNum) {
        return lottoNos.contains(bonusNum);
    }

    public int countMatch(LottoNoGroup winningLottoNoGroup) {
        return (int) lottoNos.stream().filter(i -> winningLottoNoGroup.contains(i)).count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNoGroup that = (LottoNoGroup) o;
        return Objects.equals(lottoNos, that.lottoNos);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lottoNos);
    }

    @Override
    public String toString() {
        return lottoNos.toString();
    }
}
