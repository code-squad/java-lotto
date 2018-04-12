import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {
    @Test
    public void 당첨번호_몇개_맞는지(){
        List<Integer> sixNumbers = Arrays.asList(1,2,3,4,5,6);
        Card card = new Card(sixNumbers);
        List<Integer> luckyNumbers = Arrays.asList(1,2,3,4,5,7);
        assertThat(card.numMatchLuckNumber(luckyNumbers)).isEqualTo(5);
    }

}
