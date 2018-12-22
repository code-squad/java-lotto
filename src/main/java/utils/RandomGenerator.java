package utils;

import vo.Num;

import java.util.*;

public class RandomGenerator {
    public static final int A_NUMBER_OF_LOTTO = 6;

    public static List<Num> generateRandomNumber() {
        Set<Num> ranndomLottos = new HashSet<>();
        Random rnd = new Random();
        while(ranndomLottos.size() < A_NUMBER_OF_LOTTO) {
            ranndomLottos.add(new Num(rnd.nextInt(Num.MAX_NUM) + 1));
        }

        return new ArrayList<>(ranndomLottos);
    }
}
