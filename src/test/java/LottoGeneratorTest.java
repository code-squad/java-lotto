import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    public void 범위로_리스트_생성한다(){
        List<Integer> result = LottoGenerator.createLottoValidNumbers(4);
        List<Integer> expect = Arrays.asList(1,2,3,4);
        assertThat(result).isEqualTo(expect);
    }

    /*
    @Test
    public void 번호를_섞는다(){
        List<Integer> source = Arrays.asList(1,2,3,4,5);
        List<Integer> result = LottoGenerator.shuffleCardNumbers(source);
        assertThat(source).isNotEqualTo(result);
    }
    */
    @Test
    public void 여섯개를_뽑늗다(){
        List<Integer> source = Arrays.asList(1,2,3,4,5,6,7);
        assertThat(LottoGenerator.pickSixNumbers(source)).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }

}
