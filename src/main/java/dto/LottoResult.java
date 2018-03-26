package dto;

import utils.LottoMachine;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private List<LottoDto> lottoResults = new ArrayList<>();

    public void addResult(LottoDto lottoDto) {
        lottoResults.add(lottoDto);
    }

    public int calcMatchNum(int matchPoint) {
        int matchNum = 0;
        for (LottoDto lottoDto : lottoResults) {
            if (lottoDto.isRightMatchPoint(matchPoint)) {
                matchNum++;
            }
        }
        return matchNum;
    }

    public int calcLottoProfit(long money) {
        int investedAmount = lottoResults.size() * LottoMachine.LOTTO_PRICE;
        return (int)((money / investedAmount) * 100);
    }
}
