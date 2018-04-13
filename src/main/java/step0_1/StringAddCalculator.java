package step0_1;

public class StringAddCalculator {

  static Parser parser = new Parser();

  public static void main(String[] args){
    //TODO custom 구분자입력 안됨
    ResultView.printOutput(add(InputView.getInput()));
  }

  public static double add(String input){
    String[] inputs = parser.doSplit(input);
    double result = 0.0;
    for(String num : inputs){
      result += Double.parseDouble(num);
    }
    return result;
  }
}
