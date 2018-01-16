import model.RandomNumber;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RandomNumberTest {

    List<Integer> result = RandomNumber.shuffleNumber();

    @Test
    public void shuffleNumber(){
        assertThat(result.size()).isEqualTo(6);
        assertThat(result.get(0)).isBetween(1, 45);
        assertThat(result.get(5)).isBetween(1, 45);
    }
}
