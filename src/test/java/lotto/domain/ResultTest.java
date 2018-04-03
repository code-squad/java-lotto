package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ResultTest {

    @Test
    public void countMatches() {
        List<Match> matches = Arrays.asList(Match.ofMatch(5, true)); //one second place in the list
        int matchCounts = Result.countMatches(matches, Match.SECOND);
        assertThat(matchCounts).isEqualTo(1);
    }
}