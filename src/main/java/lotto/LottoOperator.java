package lotto;

import lotto.domain.*;
import lotto.util.TicketNumberParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoOperator {
    private List<Integer> successNumbers;

    public LottoOperator(String successNumberString) {
        this.successNumbers = TicketNumberParser.parse(successNumberString);

        validateCountOfLottoNumbers();
        validateLottoNumbers();
    }

    private void validateLottoNumbers() {
        for (Integer successNumber : successNumbers) {
            validateLottoNumber(successNumber);

        }
    }

    private void validateCountOfLottoNumbers() {
        if (successNumbers.size() != LottoConstants.NUMBER_COUNT) {
            throw new IllegalArgumentException("successNumbers=" + successNumbers.toString());
        }
    }

    private void validateLottoNumber(Integer successNumber) {
        if (successNumber < LottoConstants.FIRST_NUMBER || successNumber > LottoConstants.LAST_NUMBER) {
            throw new IllegalArgumentException("successNumber=" + successNumber);
        }
    }

    public List<Integer> getSuccessNumbers() {
        return successNumbers;
    }

    public LottoPrize match(LottoTicket lottoTicket) {
        int matchCount = 0;
        for (Integer successNumber : successNumbers) {
            if (lottoTicket.match(successNumber)) {
                matchCount++;
            }
        }
        return LottoPrize.letMeKnowPrize(matchCount);
    }

    public LottoResult match(CustomerLottoTickets customerLottoTickets, int ticketTotalPrice) {
        Map<LottoPrize, Integer> lottoPrizeResults = new HashMap<>();
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            lottoPrizeResults.put(lottoPrize, 0);
        }

        for (LottoTicket lottoTicket : customerLottoTickets.getTickets()) {
            LottoPrize lottoPrize = match(lottoTicket);
            lottoPrizeResults.put(lottoPrize, lottoPrizeResults.get(lottoPrize) + 1);
        }
        return new LottoResult(lottoPrizeResults, ticketTotalPrice);
    }
}
