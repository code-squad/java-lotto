package lotto;

import lotto.domain.*;
import lotto.util.TicketNumberParser;

import java.util.List;

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

}
