package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LottoMachine {
    private static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = 6;

    static List<Lotto> publishLotto(int amount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (; amount > 0; amount--) {
            lottoList.add(new Lotto(makeRandomLottoNumber()));
        }

        return lottoList;
    }

    private static List<Integer> makeRandomLottoNumber() {
        List<Integer> list = IntStream
                .rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());

        return sortASC(slice(shuffleList(list)));
    }

    private static List<Integer> sortASC(List<Integer> list) {
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
