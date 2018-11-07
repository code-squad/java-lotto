package util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParserTest {
    @Test
    public void makeWinnerLottoTest(){
        String str = "1,2,3,4,5,6";
        List<Integer> sample = new ArrayList<>();
        for(int i = 1 ; i<=6;i++){
            sample.add(i);
        }
        List<Integer> winnerLotto = Parser.makeIntegerList(str);
        assertThat(winnerLotto.size()).isEqualTo(6);
        assertThat(winnerLotto).isEqualTo(sample);
    }
}
