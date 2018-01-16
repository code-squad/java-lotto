package lotto;

import lotto.domain.*;
import lotto.util.TicketNumberParser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private List<LottoNumber> successNumbers;
    private LottoNumber bonusNumber;

    public WinningLotto(String successNumberString, String bonusNumberString) {
        this.successNumbers = TicketNumberParser.parse(successNumberString);
        this.bonusNumber = LottoNumber.newInstance(bonusNumberString);

        validateCountOfLottoNumbers();
        validateLottoNumbers();
        validateDuplicatedNumbers();
    }

    private void validateDuplicatedNumbers() {
        Set<LottoNumber> set = new HashSet<>();
        set.addAll(successNumbers);
        set.add(bonusNumber);

        if (set.size() != LottoConstants.NUMBER_COUNT + 1) {
            throw new IllegalArgumentException("successNumbers=" + successNumbers.toString()
                    + ", bonusNumber=" + bonusNumber);
        }
    }

    private void validateLottoNumbers() {
        for (LottoNumber successNumber : successNumbers) {
            successNumber.validate();
        }
        bonusNumber.validate();
    }

    private void validateCountOfLottoNumbers() {
        if (successNumbers.size() != LottoConstants.NUMBER_COUNT) {
            throw new IllegalArgumentException("successNumbers=" + successNumbers.toString());
        }
    }

    public List<LottoNumber> getSuccessNumbers() {
        return successNumbers;
    }

    public LottoPrize match(LottoTicket lottoTicket) {
        int matchCount = 0;
        for (LottoNumber successNumber : successNumbers) {
            if (lottoTicket.match(successNumber)) {
                matchCount++;
            }
        }

        return LottoPrize.letMeKnowPrize(matchCount, lottoTicket.match(bonusNumber));
    }

}
