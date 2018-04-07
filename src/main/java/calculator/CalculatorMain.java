package calculator;

public class CalculatorMain {
    public static void main(String[] args) {
        String userInput = ConsoleInput.getUserInput();
        Calculator calculator = new Calculator();
        int result = calculator.calculate(userInput);
        System.out.println(result);
    }
}
