package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    List<Splitter> operators;

    public Calculator(){
        operators = new ArrayList<>();
        operators.add(new CustomSplitter(","));
        operators.add(new CustomSplitter(":"));
    }

    public List<Splitter> getOperators() {
        return operators;
    }

    public int calculate(String userInput) {
        if(userInput == null || userInput.isEmpty())
            return 0;

        userInput = addNewOperator(userInput);

        Positive resultNumber = sumSplittedString(splitByOperators(userInput));
        return resultNumber.getNumber();

    }

    public String splitByOperators(String inputString){
        for(Splitter splitter : operators){
            inputString = splitStringBySplittor(inputString, splitter);
        }
        return inputString;
    }

    public String splitStringBySplittor(String inputString,  Splitter splitter) {
        String[] splitResult = splitter.split(inputString);
        return String.join(" ", splitResult);
    }

    public Positive sumSplittedString(String inputString){
        Positive resultNumber = new Positive(0);
        Positive newNumber;
        String [] splittedStrings = inputString.split(" ");
        for(String number:splittedStrings) {
            newNumber = new Positive(number);
            resultNumber.addNumber(newNumber);
        }
        return resultNumber;
    }

    public String addNewOperator(String userInput) {
        if(!userInput.contains("\\\\"))
            return userInput;
        operators.add( new CustomSplitter(userInput.substring( 2, userInput.indexOf("\\n") ) ) );
        userInput = userInput.substring(userInput.lastIndexOf("\\n") + 2);
        return userInput;

    }
}
