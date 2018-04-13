package step0_2;

public class StringAddCalculator {

  static Parser parser = new Parser();

  public double add(String input){
    Input nums = new Input(input);

    double result = 0.0;
    for(Positive num : nums.getPositive()){
      result += num.getNumber();
    }
    return result;
  }
}
