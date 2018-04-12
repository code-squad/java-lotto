package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    List<String> operators;

    public Calculator(){
        operators = new ArrayList<>();
        operators.add(",");
        operators.add(":");
    }

    public List<String> getOperators() {
        return operators;
    }

    public int calculate(String userInput) {
        if(userInput == null || userInput.isEmpty())
            return 0;

        userInput = addNewOperator(userInput);

        List<String> inputStrings = new ArrayList<>();
        inputStrings.add(userInput);

        Positive resultNumber = sumSplittedString(splitByOperators(inputStrings));
        return resultNumber.getNumber();

    }

    public List<String> splitByOperators(List<String> inputStrings){
        for(int i=0; i<operators.size(); i++){
            inputStrings = splitStringBySplittor(inputStrings, operators.get(i));
        }
        return inputStrings;
    }

    public List<String> splitStringBySplittor(List<String> resultStrings, String splitor) {
        String userInput;

        for(int i=0; i<resultStrings.size(); i++){
            userInput = resultStrings.get(i);
            splitFromList(resultStrings, splitor, userInput, i);
        }
        return resultStrings;
    }

    private void splitFromList(List<String> resultStrings, String splitor, String userInput, int i) {
        if( userInput.contains(splitor) ) {
            String[] splitStrings = userInput.split(splitor);
            resultStrings.addAll(makeNewList(splitStrings, resultStrings));
            resultStrings.remove(i);
        }
    }

    private List<String> makeNewList(String[] splitStrings, List<String> paramStrings) {
        List<String> resultStrings = new ArrayList<>();
        for(String simpleString : splitStrings){
            resultStrings.add(simpleString);
        }
        return resultStrings;
    }


    public Positive sumSplittedString(List<String> inputStrings){
        Positive resultNumber = new Positive(0);
        Positive newNumber;
        for(String number:inputStrings) {
            newNumber = new Positive(number);
            resultNumber.addNumber(newNumber);
        }
        return resultNumber;
    }

    private int checkNonNegative(String number) {
        if( !StringUtils.isNumeric(number) )
            throw new RuntimeException();

        int inputNumber = Integer.parseInt(number);
        if(inputNumber < 0)
            throw new RuntimeException();
        return inputNumber;
    }

    public String addNewOperator(String userInput) {
        if(!userInput.contains("\\\\"))
            return userInput;
        operators.add(userInput.substring(2, userInput.indexOf("\\n")));
        userInput = userInput.substring(userInput.lastIndexOf("\\n") + 2);
        return userInput;

    }
}
