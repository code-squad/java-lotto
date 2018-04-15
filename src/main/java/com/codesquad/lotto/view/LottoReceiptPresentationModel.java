package com.codesquad.lotto.view;

import com.codesquad.lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoReceiptPresentationModel {

    final List<Lotto> lottos;

    public LottoReceiptPresentationModel(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public String countMessage() {
        return String.format("%d개를 구매했습니다.", lottos.size());
    }

    public String lottoList() {
        final List<String> list = lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.toList());
        return String.join("\r\n", list);
    }
}
