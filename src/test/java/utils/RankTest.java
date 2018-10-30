package utils;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    public void 로또_Rank_5등_확인() {
        assertThat(Rank.valueOf(3, true)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
    }

    @Test
    public void 로또_Rank_4등_확인() {
        assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
    }

    @Test
    public void 로또_Rank_3등_확인() {
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THRID);
    }

    @Test
    public void 로또_Rank_2등_확인() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
//        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.SECOND);
    }

    @Test
    public void 로또_Rank_1등_확인() {
        assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
    }

    @Test
    public void Rank_Values_어떤순서로_호출할까() {  // 위부터 차례대로 호출
        for (Rank value : Rank.values()) {
            System.out.println(value);
        }
    }

    @Test
    public void Rank에_맞는_Map_호출_및_출력형식() {
        Map<Rank, Integer> result = new HashMap<>();
        result.put(Rank.FIFTH, 2);
        result.put(Rank.FOURTH, 1);
        result.put(Rank.THRID, 0);
        result.put(Rank.SECOND, 5);
        result.put(Rank.FIRST, 2);

        for (Rank value : Rank.values()) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCountOfStrike() + "개 일치");
            if(value.equals(Rank.SECOND)) {
                sb.append(", 보너스 볼 일치");
            }
            sb.append(" (" + value.getWinningMoney() + "원) ");
            sb.append("- " + result.get(value) + "개");
            System.out.println(sb.toString());
        }
    }

    @Test
    public void Rank에게_물어서_상금받기_1등() {
        assertThat(Rank.findWinningMoney(Rank.FIRST)).isEqualTo(2000000000);
    }

    @Test
    public void Rank에게_물어서_상금받기_2등() {
        assertThat(Rank.findWinningMoney(Rank.SECOND)).isEqualTo(30000000);
    }

    @Test
    public void Rank에게_물어서_상금받기_3등() {
        assertThat(Rank.findWinningMoney(Rank.THRID)).isEqualTo(1500000);
    }

    @Test
    public void Rank에게_물어서_상금받기_4등() {
        assertThat(Rank.findWinningMoney(Rank.FOURTH)).isEqualTo(50000);
    }

    @Test
    public void Rank에게_물어서_상금받기_5등() {
        assertThat(Rank.findWinningMoney(Rank.FIFTH)).isEqualTo(5000);
    }
}