package com.zingoworks.lotto.domain;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LottoResultTest {
    @Test
    public void 테스트() {
        Map<Score, Integer> t = new HashMap<>();
        t.put(new Score(0,false), t.get(new Score(0,false)) + 1);
        System.out.println(t.get(new Score(0,false)));
    }
}