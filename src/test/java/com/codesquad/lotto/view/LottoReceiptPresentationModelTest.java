package com.codesquad.lotto.view;

import com.codesquad.lotto.domain.Lotto;
import com.codesquad.lotto.domain.LottoBundle;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoReceiptPresentationModelTest {

    private LottoBundle bundle;

    @Before
    public void setUp() throws Exception {
        bundle = new LottoBundle(Arrays.asList(
                Lotto.of(5, 6, 7, 8, 9, 10)
        ));
    }

    @Test
    public void 생성() {
        new LottoReceiptPresentationModel(bundle);
    }

    @Test
    public void 로또수량_1() {
        final LottoReceiptPresentationModel model = new LottoReceiptPresentationModel(bundle);
        final String msg = model.countMessage();
        assertThat(msg).isEqualTo("1개를 구매했습니다.");
    }

    @Test
    public void 로또수량_2() {
        bundle = new LottoBundle(Arrays.asList(
                Lotto.of(1, 2, 3, 4, 5, 6),
                Lotto.of(2, 3, 4, 5, 6, 7)
        ));
        final LottoReceiptPresentationModel model = new LottoReceiptPresentationModel(bundle);
        final String msg = model.countMessage();
        assertThat(msg).isEqualTo("2개를 구매했습니다.");
    }

    @Test
    public void 로또목록_1() {
        final LottoReceiptPresentationModel model = new LottoReceiptPresentationModel(bundle);
        final String lottoList = model.lottoList();
        assertThat(lottoList).isEqualTo("[5, 6, 7, 8, 9, 10]");
    }

    @Test
    public void 로또목록_2() {
        bundle = new LottoBundle(Arrays.asList(
                Lotto.of(5, 6, 7, 8, 9, 10),
                Lotto.of(5, 6, 7, 8, 9, 10)
        ));
        final LottoReceiptPresentationModel model = new LottoReceiptPresentationModel(bundle);
        final String lottoList = model.lottoList();
        assertThat(lottoList).isEqualTo("[5, 6, 7, 8, 9, 10]\r\n[5, 6, 7, 8, 9, 10]");
    }
}
