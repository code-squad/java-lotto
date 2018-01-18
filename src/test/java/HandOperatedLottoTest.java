import model.HandOperatedLotto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HandOperatedLottoTest {

    @Test
    public void HandOperatedLotto(){
        String[] lottoNumbers = new String[1];
        lottoNumbers[0] = "1,2,3,4,5,6";
        HandOperatedLotto handOperatedLotto = new HandOperatedLotto(1, lottoNumbers);
        assertThat(handOperatedLotto.getLottos().size()).isEqualTo(1);
        assertThat(handOperatedLotto.getNumberOfLotto()).isEqualTo(1);
    }
}
