package domain;

import io.InputView;
import io.ResultView;
import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static constant.Constant.LOTTO_PRICE;

/**
 * Created by hoon on 2018. 1. 14..
 */
public class Main {
    public static void main(String[] args) {

        Integer money = InputView.readMoney();
        Integer ticketCount = money/LOTTO_PRICE;

        List<Ticket> tickets = new ArrayList<>();
        for(int i = 0; i < ticketCount; i++) {
            List<Integer> randomNumbers = Utils.generateRandomNumbers(6);
            Ticket ticket = new Ticket(new Numbers(randomNumbers));
            tickets.add(ticket);
        }

        ResultView.printTickets(tickets);

        List<Integer> numbers = Arrays.stream(InputView.readWinningNumbers().split(", "))
                .flatMapToInt(s -> IntStream.of(Integer.parseInt(s)))
                .boxed()
                .collect(Collectors.toList());

        Lotto lotto = new Lotto(tickets, new Numbers(numbers));

        ResultView.printResult(lotto.lottery());
    }
}
