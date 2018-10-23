package domain;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    @Test
    public void countGameNum() {
        /* 인스턴스 변수를 사용하지 않는 메소드이기 때문에 스태틱 메소드를 사용 */
        assertThat(LottoGame.countGameNum(19000)).isEqualTo(19);
    }
}
