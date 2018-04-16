package com.codesquad.lotto.view;

import com.codesquad.lotto.domain.LottoGameResult;
import com.codesquad.lotto.domain.WinType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoStatsPresentationModel {

    private final LottoGameResult stats;

    public LottoStatsPresentationModel(final LottoGameResult stats) {
        this.stats = stats;
    }

    public String winCountMessage(final WinType winType) {
        final int winingCount = stats.getWiningCount(winType);
        return String.format("%s- %d개", winType, winingCount);
    }

    public String winCountListMessage() {
        final List<String> messages = Arrays.stream(WinType.values())
                .filter(WinType::isWin)
                .map(this::winCountMessage)
                .collect(Collectors.toList());
        return String.join("\r\n", messages);
    }

    public String profitMessage() {
        return String.format("총 수익률은 %d%%입니다.", stats.getProfitRate());
    }
}
