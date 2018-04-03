package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketFactory {
    private static final int MAX_SIZE = 6;

    public static LottoTicket getLottoTicket() throws Exception{
        return new LottoTicket(makeRandomNumbers());
    }

    public static LottoTicket getWinningLottoTicket(List<Integer> numbers) throws Exception {
        return new LottoTicket(numbers);
    }

    public static List<Integer> makeRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> numberPool = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            numberPool.add(i);
        }

        Collections.shuffle(numberPool);
        for (Integer number : numberPool) {
            if (numbers.size() >= MAX_SIZE) {
                break;
            }
            numbers.add(number);
        }
        numbers.sort(Integer::compareTo);
        System.out.println(numbers);
        return numbers;
    }
}
