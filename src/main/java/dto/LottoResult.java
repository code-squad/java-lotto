package dto;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private List<LottoDto> lottoResults = new ArrayList<>();

    public void addResult(LottoDto lottoDto) {
        lottoResults.add(lottoDto);
    }

    public int calcPrizeMatchNum(int matchPoint, boolean isBonusMatch) {
        int cnt = 0;
        for (LottoDto lottoDto : lottoResults) {
            if (lottoDto.isRightMatchPoint(matchPoint) && lottoDto.isRightBonusMatch(isBonusMatch)) {
                cnt++;
            }
        }
        return cnt;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (LottoDto lottoDto : lottoResults) {
            builder.append(lottoDto.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
