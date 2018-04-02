package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoTicketFactory {
    public static LottoTicket getLottoTicket() {
        return new LottoTicket(makeRanomNumbers());
    }

    public static List<Integer> makeRanomNumbers() {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            int randomNumber = random.nextInt(45) + 1; // 0~44 보정
            if (numbers.contains(randomNumber)) {
                continue;
            }
            numbers.add(randomNumber);
        }
        numbers.sort(Integer::compareTo);
        System.out.println(numbers);
        return numbers;
    }
}
