package domain;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<Integer> numberPool = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45);

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
