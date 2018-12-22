package domain;

import dto.LottoDto;
import vo.Num;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTOSIZE = 6;

    private List<Num> lottoNumbers;

    private Lotto(List<Num> inputLotto) {
        Collections.sort(checkReduplication(inputLotto));
        this.lottoNumbers = inputLotto;
    }

    public static Lotto ofList(List<Num> inputLotto) {
        return new Lotto(inputLotto);
    }

    public static Lotto of(String inputLotto) {
        List<Num> lottoNums = Arrays.stream(inputLotto.split(","))
                .map(Integer::parseInt)
                .map(Num::new)
                .collect(Collectors.toList());

        return new Lotto(lottoNums);
    }

    private List<Num> checkReduplication(List<Num> inputLotto) {
        Set<Num> lotto = new HashSet<>(inputLotto);
        if (lotto.size() != LOTTOSIZE) throw new IllegalArgumentException();

        return inputLotto;
    }

    public int checkNum(Lotto winnerLotto) {
        int checkNum =0;
        for (Num lottoNumber : lottoNumbers) {
            if (winnerLotto.lottoNumbers.contains(lottoNumber)) checkNum++;
        }

        return checkNum;
    }

    public LottoDto toDto() {
        return new LottoDto(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers + "" ;
    }
}
