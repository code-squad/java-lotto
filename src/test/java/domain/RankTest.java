package domain;

import org.junit.Test;
import vo.Rank;

public class RankTest {

    @Test
    public void print() {
        for (Rank rank : Rank.values()) {
            System.out.println(rank);
        }
    }

}