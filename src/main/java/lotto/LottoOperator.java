package lotto;

import lotto.domain.*;
import lotto.util.TicketNumberParser;

import java.util.List;

public class LottoOperator {
    private List<Integer> successNumbers;
    private int bonusNumber;

    public LottoOperator(String successNumberString, String bonusNumberString) {
        this.successNumbers = TicketNumberParser.parse(successNumberString);
        this.bonusNumber = Integer.parseInt(bonusNumberString);

        validateCountOfLottoNumbers();
        validateLottoSuccessNumbers();
        validateLottoNumber(bonusNumber);
    }

    private void validateLottoSuccessNumbers() {
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

        return LottoPrize.letMeKnowPrize(matchCount, lottoTicket.match(bonusNumber));
    }

}
