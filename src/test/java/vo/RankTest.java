package vo;

import org.junit.Test;

import static org.junit.Assert.*;

public class RankTest {

    @Test
    public void print() {
        for (Rank rank : Rank.values()) {
            System.out.println(rank);
        }
    }

}