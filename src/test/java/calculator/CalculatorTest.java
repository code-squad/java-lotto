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
        List<String> expectResults = new ArrayList<>();
        expectResults.add("1");
        expectResults.add("2");

        List<String> inputStrings = new ArrayList<>();
        inputStrings.add("1,2");
        List<String> resultStrings = calculator.splitStringBySplittor(inputStrings, ",");
        assertThat(resultStrings).isEqualTo(expectResults);
    }

    @Test
    public void splitByColon() {
        Calculator calculator = new Calculator();
        List<String> expectResults = new ArrayList<>();
        expectResults.add("1");
        expectResults.add("2");

        List<String> inputStrings = new ArrayList<>();
        inputStrings.add("1:2");
        List<String> resultStrings = calculator.splitStringBySplittor(inputStrings, ":");
        assertThat(resultStrings).isEqualTo(expectResults);
    }


    @Test
    public void splitByCommaAndColon() {
        Calculator calculator = new Calculator();
        List<String> expectResults = new ArrayList<>();
        expectResults.add("1");
        expectResults.add("2");
        expectResults.add("3");

        List<String> inputStrings = new ArrayList<>();
        inputStrings.add("1,2:3");
        List<String> resultStrings = calculator.splitByOperators(inputStrings);
        assertThat(resultStrings).isEqualTo(expectResults);
    }

    @Test
    public void addNewOperator() {
        Calculator calculator = new Calculator();
        calculator.addNewOperator("\\\\;\\n");

        List<String> operators = new ArrayList<>();

        operators.add(",");
        operators.add(":");
        operators.add(";");

        assertThat(calculator.getOperators()).isEqualTo(operators);
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
