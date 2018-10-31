package com.zingoworks.lotto.model.lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 로또_빈생성자() {
        System.out.println(Lotto.random());
        System.out.println(Lotto.random());
        System.out.println(Lotto.random());

        List<Lotto> a = new ArrayList<>();
        a.add(Lotto.random());
        a.add(Lotto.of("1,2,3,4,5,6"));
        a.add(Lotto.random());
        System.out.println(a);
    }

    @Test
    public void 로또_문자() {
        Lotto lotto = Lotto.of("3,2,1,4,5,6");
        System.out.println(lotto);
    }


//    @Test
//    public void 로또_로또넘버리스트() {
//        List<LottoNumber> any = Arrays.asList(LottoNumber.of(4)
//                , LottoNumber.of(2)
//                , LottoNumber.of(3)
//                , LottoNumber.of(1)
//                , LottoNumber.of(6)
//                , LottoNumber.of(5));
//        Lotto lotto = new Lotto(any);
//        System.out.println(lotto);
//    }

    @Test
    public void 로또_적중개수() {
        Lotto lotto = Lotto.of("1,2,3,4,5,6");
        Lotto other = Lotto.of("4,5,6,7,8,9");
        assertThat(lotto.match(other)).isEqualTo(3);
    }

    @Test
    public void 로또_포함여부() {
        Lotto lotto = Lotto.of("1,2,3,4,5,6");
        assertThat(lotto.isContain(LottoNumber.of(1))).isEqualTo(true);
    }
}