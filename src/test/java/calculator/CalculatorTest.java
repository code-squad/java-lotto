package calculator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    @Test
    public void inputNullReturnZero() {
        Calculator calculator = new Calculator();
        int calculateResult = calculator.calculate("");
        assertThat(calculateResult).isEqualTo(0);
    }

    @Test
    public void inputSigle() {
        Calculator calculator = new Calculator();
        int calculateResult = calculator.calculate("1");
        assertThat(calculateResult).isEqualTo(1);
    }

    @Test
    public void splitByComma() {
        Calculator calculator = new Calculator();

        String expectResults = "1 2";

        String inputStrings = "1,2";
        Splitter splitter = new CustomSplitter(",");
        String resultStrings = calculator.splitStringBySplittor(inputStrings, splitter);
        assertThat(resultStrings).isEqualTo(expectResults);
    }

    @Test
    public void splitByColon() {
        Calculator calculator = new Calculator();
        String expectResults = "1 2";

        String inputStrings = "1:2";
        Splitter splitter = new CustomSplitter(":");
        String resultStrings = calculator.splitStringBySplittor(inputStrings, splitter);
        assertThat(resultStrings).isEqualTo(expectResults);
    }


    @Test
    public void splitByCommaAndColon() {
        Calculator calculator = new Calculator();
        String expectString = "1 2 3";
        String inputString = "1,2:3";


        assertThat(calculator.splitByOperators(inputString)).isEqualTo(expectString);
    }

    @Test
    public void addNewOperator() {
        Calculator calculator = new Calculator();
        calculator.addNewOperator("\\\\;\\n");

        List<Splitter> operators = new ArrayList<>();

        operators.add(new CustomSplitter(","));
        operators.add(new CustomSplitter(":"));
        operators.add(new CustomSplitter(";"));

        assertThat(calculator.getOperators().size()).isEqualTo(operators.size());
    }

    @Test
    public void removeNewOperatorFromInputString() {
        Calculator calculator = new Calculator();
        String newString = calculator.addNewOperator("\\\\;\\n1:2");
        assertThat(newString).isEqualTo("1:2");

    }

    @Test
    public void calculateAllCase() {
        Calculator calculator = new Calculator();
        int resultSum = calculator.calculate("\\\\;\\n1;2:3:4");
        assertThat(resultSum).isEqualTo(10);

    }
}
