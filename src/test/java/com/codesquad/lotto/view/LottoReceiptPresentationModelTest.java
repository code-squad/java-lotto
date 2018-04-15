package com.codesquad.lotto.view;

import com.codesquad.lotto.domain.Lotto;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoReceiptPresentationModelTest {

    private List<Lotto> lottos;

    @Before
    public void setUp() throws Exception {
        lottos = new ArrayList<>();
        lottos.add(Lotto.fromList(Arrays.asList(5, 6, 7, 8, 9, 10)));
    }

    @Test
    public void 생성() {
        new LottoReceiptPresentationModel(lottos);
    }

    @Test
    public void 로또수량_1() {
        final LottoReceiptPresentationModel model = new LottoReceiptPresentationModel(lottos);
        final String msg = model.countMessage();
        assertThat(msg).isEqualTo("1개를 구매했습니다.");
    }

    @Test
    public void 로또수량_2() {
        lottos.add(Lotto.fromList(Arrays.asList(2, 3, 4, 5, 6, 7)));
        final LottoReceiptPresentationModel model = new LottoReceiptPresentationModel(lottos);
        final String msg = model.countMessage();
        assertThat(msg).isEqualTo("2개를 구매했습니다.");
    }

    @Test
    public void 로또목록_1() {
        final LottoReceiptPresentationModel model = new LottoReceiptPresentationModel(lottos);
        final String lottoList = model.lottoList();
        assertThat(lottoList).isEqualTo("[5, 6, 7, 8, 9, 10]");
    }

    @Test
    public void 로또목록_2() {
        lottos.add(Lotto.fromList(Arrays.asList(2, 3, 4, 5, 6, 7)));
        final LottoReceiptPresentationModel model = new LottoReceiptPresentationModel(lottos);
        final String lottoList = model.lottoList();
        assertThat(lottoList).isEqualTo("[5, 6, 7, 8, 9, 10]\r\n[2, 3, 4, 5, 6, 7]");
    }
}
