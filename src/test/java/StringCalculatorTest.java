import stringcalculator.StringCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hongjong-wan on 2018. 4. 7..
 */
public class StringCalculatorTest {

    /**
     * 테스트 케이스 정리
     * 1. 빈문자열/null -> 0 (통과)
     * 2. 숫자 하나를 전달 -> 해당 숫자 반환 (통과)
     * 3. 숫자를,로 전달 -> 합 (통과)
     * 4. 숫자를:로 전달 -> 합 (통과)
     * 5. 숫자를,와:로 전달 -> 합 (통과)
     * 6. 커스텀 구분자를 사용한 경우 -> 합 (통과)
     * 7. 음수 전달 -> RuntimeException (통과)
     *     - 숫자가 아닌 값은 자동으로 NumberFormatException 발생시킴
     */

    @Test
    public void add_입력값이빈문자열() {
        // 인스턴스 필요없으면 클래스 메소드
        // 추상화 레벨을 맞춰줘라 - composite pattern
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void add_입력값이NULL() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void add_숫자하나() {
        assertEquals(3, StringCalculator.add("3"));
    }

    @Test
    public void add_숫자를쉼표로연결() {
        assertEquals(6, StringCalculator.add("2,4"));
    }

    @Test
    public void add_숫자를콜론으로연결() {
        assertEquals(8, StringCalculator.add("2:4:2"));
    }

    @Test
    public void add_숫자를쉼표와콜론으로연결() {
        assertEquals(8, StringCalculator.add("2,4:2"));
    }

    @Test
    public void add_숫자를커스텀구분자로연결() {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test(expected = RuntimeException.class)
    public void add_음수값() {
        assertEquals(true, StringCalculator.isPositiveNumber("-1:2:3"));
    }
}
