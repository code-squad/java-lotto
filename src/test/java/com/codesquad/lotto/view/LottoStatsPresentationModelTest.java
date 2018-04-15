package com.codesquad.lotto.view;

import com.codesquad.lotto.domain.Lotto;
import com.codesquad.lotto.domain.LottoStats;
import com.codesquad.lotto.domain.WinType;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatsPresentationModelTest {
    @Test
    public void 번호3개일치_1개() {
        final LottoStatsPresentationModel model = new LottoStatsPresentationModel(
                new LottoStats(Arrays.asList(
                        Lotto.of(1, 2, 3, 4, 5, 6)
                ), Lotto.of(1, 2, 3, 7, 8, 9)));

        final String msg = model.winCountMessage(WinType.THREE);
        assertThat(msg).isEqualTo("3개 일치 (5000원)- 1개");
    }

    @Test
    public void 번호4개일치_2개() {
        final LottoStatsPresentationModel model = new LottoStatsPresentationModel(
                new LottoStats(Arrays.asList(
                        Lotto.of(1, 2, 3, 4, 5, 6),
                        Lotto.of(5, 6, 7, 8, 9, 10)
                ), Lotto.of(3, 4, 5, 6, 7, 8)));

        final String msg = model.winCountMessage(WinType.FOUR);
        assertThat(msg).isEqualTo("4개 일치 (50000원)- 2개");
    }

    @Test
    public void 번호일치개수별_당첨수목록_1개씩() {
        final LottoStatsPresentationModel model = new LottoStatsPresentationModel(
                new LottoStats(Arrays.asList(
                        Lotto.of(1, 2, 3, 4, 5, 6),
                        Lotto.of(2, 3, 4, 5, 6, 7),
                        Lotto.of(3, 4, 5, 6, 7, 8),
                        Lotto.of(4, 5, 6, 7, 8, 9),
                        Lotto.of(5, 6, 7, 8, 9, 10)
                ), Lotto.of(1, 2, 3, 4, 5, 6)));

        final String msg = model.winCountListMessage();

        final StringBuilder sb = new StringBuilder();
        sb.append("3개 일치 (5000원)- 1개\r\n");
        sb.append("4개 일치 (50000원)- 1개\r\n");
        sb.append("5개 일치 (1500000원)- 1개\r\n");
        sb.append("6개 일치 (2000000000원)- 1개");
        final String expected = sb.toString();
        assertThat(msg).isEqualTo(expected);
    }

    @Test
    public void 번호일치개수별_당첨수목록_2개씩() {
        final LottoStatsPresentationModel model = new LottoStatsPresentationModel(
                new LottoStats(Arrays.asList(
                        Lotto.of(1, 2, 3, 4, 5, 6),
                        Lotto.of(2, 3, 4, 5, 6, 7),
                        Lotto.of(3, 4, 5, 6, 7, 8),
                        Lotto.of(4, 5, 6, 7, 8, 9),
                        Lotto.of(5, 6, 7, 8, 9, 10),
                        Lotto.of(1, 2, 3, 4, 5, 6),
                        Lotto.of(2, 3, 4, 5, 6, 7),
                        Lotto.of(3, 4, 5, 6, 7, 8),
                        Lotto.of(4, 5, 6, 7, 8, 9),
                        Lotto.of(5, 6, 7, 8, 9, 10)
                ), Lotto.of(1, 2, 3, 4, 5, 6)));

        final String msg = model.winCountListMessage();

        final StringBuilder sb = new StringBuilder();
        sb.append("3개 일치 (5000원)- 2개\r\n");
        sb.append("4개 일치 (50000원)- 2개\r\n");
        sb.append("5개 일치 (1500000원)- 2개\r\n");
        sb.append("6개 일치 (2000000000원)- 2개");
        final String expected = sb.toString();
        assertThat(msg).isEqualTo(expected);
    }

    @Test
    public void 수익율400출력() {
        final List<Lotto> lotteries = Arrays.asList(
                Lotto.of(1, 2, 3, 4, 5, 6)
        );
        final Lotto winLotto = Lotto.of(1, 2, 3, 10, 11, 12);
        final LottoStats stats = new LottoStats(lotteries, winLotto);
        final LottoStatsPresentationModel model = new LottoStatsPresentationModel(stats);

        final String msg = model.profitMessage();

        assertThat(msg).isEqualTo("총 수익률은 400%입니다.");
    }

    @Test
    public void 수익율900출력() {
        final List<Lotto> lotteries = Arrays.asList(
                Lotto.of(1, 2, 3, 4, 5, 6),
                Lotto.of(10, 11, 12, 13, 14, 15),
                Lotto.of(10, 11, 12, 13, 14, 15),
                Lotto.of(10, 11, 12, 13, 14, 15),
                Lotto.of(10, 11, 12, 13, 14, 15)
        );
        final Lotto winLotto = Lotto.of(1, 2, 3, 4, 8, 9);
        final LottoStats stats = new LottoStats(lotteries, winLotto);
        final LottoStatsPresentationModel model = new LottoStatsPresentationModel(stats);

        final String msg = model.profitMessage();

        assertThat(msg).isEqualTo("총 수익률은 900%입니다.");
    }
}
