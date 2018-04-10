package util;

import java.util.ArrayList;
import java.util.List;

public class LottoHelper {
    private final int countOfLineNo = 6;

    public List<String> lottoNos(List<Integer> numbers) {
        List<String> numberLines = new ArrayList<>();
        List<String> numberLine = new ArrayList<>();
        for (int index = 0; index < numbers.size(); index++) {
            if(index % countOfLineNo == 0) {
                numberLines.add(String.join(",", numberLine));
                numberLine.clear();
            }
            numberLine.add(String.valueOf(numbers.get(index)));
        }
        return numberLines;
    }

    public String lottoString() {
        return "this is helper lottoNos";
    }
}
