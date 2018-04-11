package lotto.domain;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumber {

    private static final int LOTTO_SIZE = 6;
    private List<LottoMeta> lottos;

    LottoNumber() {
        this.lottos = new ArrayList<>(LOTTO_SIZE);

        for (int i = 0; i < LOTTO_SIZE; i++)
            lottos.add(new LottoMeta());
    }

    public LottoNumber(List<Integer> numbers) {
        this.lottos = Lists.newArrayList();
        for (Integer number : numbers) this.lottos.add(new LottoMeta(number));
        validate();
    }

    private void validate() {
        if (this.lottos.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public List<LottoMeta> getLottos() {
        return this.lottos;
    }

    public boolean contains(LottoMeta lottoMeta) {
        return this.lottos.contains(lottoMeta);
    }

    public int getEqualCount(LottoNumber winnerLottoNumber) {
        return Math.toIntExact(this.getLottos().stream().filter(winnerLottoNumber::contains).count());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lottos);
    }
}
