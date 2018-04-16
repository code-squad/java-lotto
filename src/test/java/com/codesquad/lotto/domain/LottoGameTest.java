package com.codesquad.lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    private LottoBundle bundle;

    @Before
    public void setUp() throws Exception {
        bundle = new LottoBundle(Arrays.asList(
                Lotto.of(5, 6, 7, 8, 9, 10)
        ));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 셔플_Null() {
        new LottoGame(1000, null);
    }

    @Test
    public void 번호6개일치_1회_게임결과() {
        final LottoGame game = new LottoGame(1000, (numbers) -> {
            numbers.clear();
            numbers.addAll(Arrays.asList(2, 3, 4, 5, 6, 7));
        });
        final HashMap<WinType, Long> countMap = new HashMap<>();
        countMap.put(WinType.SIX, 1L);
        final LottoGameResult expected = new LottoGameResult(countMap, new Money(1000));

        final LottoGameResult gameResult = game.play(Arrays.asList("2, 3, 4, 5, 6, 7"));

        assertThat(gameResult).isEqualTo(expected);
    }

    @Test
    public void 번호5개일치_2회_게임결과() {
        final LottoGame game = new LottoGame(2000, (numbers) -> {
            numbers.clear();
            numbers.addAll(Arrays.asList(2, 3, 4, 5, 6, 7));
        });
        final HashMap<WinType, Long> countMap = new HashMap<>();
        countMap.put(WinType.FIVE, 2L);
        final LottoGameResult expected = new LottoGameResult(countMap, new Money(2000));

        final LottoGameResult gameResult = game.play(Arrays.asList("2, 3, 4, 5, 6, 8"));

        assertThat(gameResult).isEqualTo(expected);
    }

    @Test
    public void 로또수량_1() {
        final LottoGame game = new LottoGame(1000, (numbers) -> {
            numbers.clear();
            numbers.addAll(Arrays.asList(2, 3, 4, 5, 6, 7));
        });
        final String msg = game.countMessage();
        assertThat(msg).isEqualTo("1개를 구매했습니다.");
    }

    @Test
    public void 로또수량_2() {
        final LottoGame game = new LottoGame(2000, (numbers) -> {
            numbers.clear();
            numbers.addAll(Arrays.asList(2, 3, 4, 5, 6, 7));
        });
        final String msg = game.countMessage();
        assertThat(msg).isEqualTo("2개를 구매했습니다.");
    }

    @Test
    public void 로또목록_1() {
        final LottoGame game = new LottoGame(1000, (numbers) -> {
            numbers.clear();
            numbers.addAll(Arrays.asList(5, 6, 7, 8, 9, 10));
        });
        final String lottoList = game.lottoList();
        assertThat(lottoList).isEqualTo("[5, 6, 7, 8, 9, 10]");
    }

    @Test
    public void 로또목록_2() {
        final LottoGame game = new LottoGame(2000, (numbers) -> {
            numbers.clear();
            numbers.addAll(Arrays.asList(5, 6, 7, 8, 9, 10));
        });
        final String lottoList = game.lottoList();
        assertThat(lottoList).isEqualTo("[5, 6, 7, 8, 9, 10]\r\n[5, 6, 7, 8, 9, 10]");
    }
}
