package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomUtils {
    public static List<Integer> pickRandom(List<Integer> target, int pickCount){
        List<Integer> pickNumber = new ArrayList<>();

        Collections.shuffle(target);
        for(int i=0 ; i<pickCount ; i++){
            pickNumber.add(target.get(i));
        }

        return pickNumber;
    }
}
