package com.codesquad.lotto.view;

import com.codesquad.lotto.application.LottoGameResult;
import com.codesquad.lotto.domain.Money;
import com.codesquad.lotto.domain.WinType;
import com.codesquad.lotto.domain.WinningMatchResult;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameResultPresentationModelTest {
    @Test
    public void 번호3개일치_1개() {
        final LottoStatsPresentationModel model = new LottoStatsPresentationModel(
                createStats(1, 0, 0, 0, 1000)
        );

        final String msg = model.winCountMessage(WinType.THREE);
        assertThat(msg).isEqualTo("3개 일치 (5000원)- 1개");
    }

    @Test
    public void 번호4개일치_2개() {
        final LottoStatsPresentationModel model = new LottoStatsPresentationModel(
                createStats(0, 2, 0, 0, 2000)
        );

        final String msg = model.winCountMessage(WinType.FOUR);
        assertThat(msg).isEqualTo("4개 일치 (50000원)- 2개");
    }

    @Test
    public void 번호일치개수별_당첨수목록_1개씩() {
        final LottoStatsPresentationModel model = new LottoStatsPresentationModel(
                createStats(1, 1, 1, 1, 5000)
        );

        final String msg = model.winCountListMessage();

        final StringBuilder sb = new StringBuilder();
        sb.append("3개 일치 (5000원)- 1개\r\n");
        sb.append("4개 일치 (50000원)- 1개\r\n");
        sb.append("5개 일치 (1500000원)- 1개\r\n");
        sb.append("5개 일치, 보너스 볼 일치 (30000000원)- 0개\r\n");
        sb.append("6개 일치 (2000000000원)- 1개");
        final String expected = sb.toString();
        assertThat(msg).isEqualTo(expected);
    }

    @Test
    public void 번호일치개수별_당첨수목록_2개씩() {
        final LottoStatsPresentationModel model = new LottoStatsPresentationModel(
                createStats(2, 2, 2, 2, 10000)
        );

        final String msg = model.winCountListMessage();

        final StringBuilder sb = new StringBuilder();
        sb.append("3개 일치 (5000원)- 2개\r\n");
        sb.append("4개 일치 (50000원)- 2개\r\n");
        sb.append("5개 일치 (1500000원)- 2개\r\n");
        sb.append("5개 일치, 보너스 볼 일치 (30000000원)- 0개\r\n");
        sb.append("6개 일치 (2000000000원)- 2개");
        final String expected = sb.toString();
        assertThat(msg).isEqualTo(expected);
    }

    @Test
    public void 수익율400출력() {
        final LottoStatsPresentationModel model = new LottoStatsPresentationModel(
                createStats(1, 0, 0, 0, 1000)
        );

        final String msg = model.profitMessage();

        assertThat(msg).isEqualTo("총 수익률은 400%입니다.");
    }

    @Test
    public void 수익율900출력() {
        final LottoStatsPresentationModel model = new LottoStatsPresentationModel(
                createStats(0, 1, 0, 0, 5000)
        );

        final String msg = model.profitMessage();

        assertThat(msg).isEqualTo("총 수익률은 900%입니다.");
    }

    private LottoGameResult createStats(final long three, final long four, final long five, final long six, final int payment) {
        final Map<WinType, Long> map = new HashMap<>();
        map.put(WinType.THREE, three);
        map.put(WinType.FOUR, four);
        map.put(WinType.FIVE, five);
        map.put(WinType.SIX, six);

        final WinningMatchResult result = new WinningMatchResult(map);

        return new LottoGameResult(result, new Money(payment));
    }
}
