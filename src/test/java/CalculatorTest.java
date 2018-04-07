import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test(expected = RuntimeException.class)
    public void 입력된_문자열이_음수일경우_예외발생() {
        Calculator.add("-1");
    }

    @Test(expected = RuntimeException.class)
    public void 입력된_문자열_숫자가_아닐경우_예외발생() {
        Calculator.add("1,2,3,[");
    }

    @Test
    public void 입력된_문자열에_숫자가_없을경우_0을_반환() {
        assertEquals(0, Calculator.add(","));
    }

    @Test
    public void 입력된_문자열에_널값이_올경우_0을_반환() {
        assertEquals(0, Calculator.add(null));
    }

    @Test
    public void 입력된_문자열이_숫자_하나일_경우_해당_숫자를_반환() {
        assertEquals(1, Calculator.add("1"));
    }

    @Test
    public void 커스텀_구분자를_지정할경우_해당_구분자가_동작() {
        assertEquals(6, Calculator.add("//;\n1;2;3"));
    }


}
