package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    @Test(expected = IllegalArgumentException.class)
    public void 안숫자() {
        LottoGame.match("안,녕,하,세,요,1", "1,2,3,4,5,6", "9");
    }

    @Test(expected =  IllegalArgumentException.class)
    public void 중복된값() {
        LottoGame.match("1,2,2,3,4,5", "1,2,3,4,5,6", "9");
        LottoGame.match("1,2,3,4,5,6", "1,2,3,4,5,6", "3"); // bonus ball duplication
    }

    @Test (expected = IllegalArgumentException.class)
    public void 영이하값(){
        LottoGame.match("-1,2,3,4,5,6", "1,2,3,4,5,6", "7");
        LottoGame.match("0,2,3,4,5,6", "1,2,3,4,5,6", "7");
    }

    @Test (expected = IllegalArgumentException.class)
    public void 안여섯개() {
        LottoGame.match("1,2,3,4,5,6", "1,2,3,4,5,6,7", "8");
        LottoGame.match("1,2,3,4,5,6,7", "1,2,3,4,5,6", "8");
    }

    @Test
    public void 일등() {
        assertThat(LottoGame.match("1,2,3,4,5,6", "1,2,3,4,5,6", "7")).isEqualTo(1);
    }

    @Test
    public void 이등() {
        assertThat(LottoGame.match("1,2,3,4,5,7", "1,2,3,4,5,6", "7")).isEqualTo(2);
    }

    @Test
    public void 삼등() {
        assertThat(LottoGame.match("1,2,3,4,5,7", "1,2,3,4,5,6", "8")).isEqualTo(3);
    }

    @Test
    public void 사등() {
        assertThat(LottoGame.match("1,2,3,4,8,9", "1,2,3,4,5,6", "7")).isEqualTo(4);
        assertThat(LottoGame.match("1,2,3,4,7,9", "1,2,3,4,5,6", "7")).isEqualTo(4);
    }

    @Test
    public void 오등() {
        assertThat(LottoGame.match("1,2,3,8,9,10", "1,2,3,4,5,6", "7")).isEqualTo(5);
    }

    @Test (expected = IllegalArgumentException.class)
    public void 보너스볼(){
        LottoGame.match("1,2,3,8,9,10", "1,2,3,4,5,6", "1");

    }




}


