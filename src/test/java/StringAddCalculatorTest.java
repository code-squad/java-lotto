import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class StringAddCalculatorTest{
    private StringAddCalculator cal;

    @Before
    public void setup(){
        cal = new StringAddCalculator();
    }

    @Test
    public void 빈문자_혹은_null(){
        assertEquals(0, cal.add(""));
        assertEquals(0, null);
    }

    @Test
    public void 숫자_하나(){
        assertEquals(1, cal.add("1"));
    }

    @Test
    public void 숫자_여러개_기본토큰(){
        assertEquals(6, cal.add("1,2:3"));
    }

    @Test
    public void 커스텀_구분자(){
        assertEquals(6, cal.add("//;\n1;2;3"));
    }

    @Test (expected = RuntimeException.class)
    public void 음수포함일때_예외발생() throws Exception{
        cal.add("-1,-4,5");
    }
}