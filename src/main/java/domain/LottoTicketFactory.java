package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketFactory {
    private static final int MAX_SIZE = 6;

    // for auto
    public static LottoTicket getLottoTicket() {
        return new LottoTicket(LottoNoFactory.getLottoNo(makeRandomNumbers()));
    }

    // for manual
    public static LottoTicket getLottoTicket(List<Integer> numbers) {
        return new LottoTicket(LottoNoFactory.getLottoNo(numbers));
    }

    public static WinningLotto getWinningLottoTicket(List<LottoNo> numbers, LottoNo bonus) {
        return new WinningLotto(numbers, bonus);
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