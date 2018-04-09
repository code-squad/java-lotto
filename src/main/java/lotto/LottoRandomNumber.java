package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class LottoRandomNumber implements Random {

    private static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = 6;

    @Override
    public List<Integer> getLottoNumbers() {

        List<Integer> list = IntStream
                .rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());

        return sortASC(slice(shuffleList(list)));
    }

    private List<Integer> sortASC(List<Integer> list) {
        Collections.sort(list);
        return list;
    }

    private static List<Integer> slice(List<Integer> list) {
        return list.subList(FIRST_INDEX, LAST_INDEX);
    }

    private static List<Integer> shuffleList(List<Integer> list) {
        Collections.shuffle(list);
        return list;
    }
}
