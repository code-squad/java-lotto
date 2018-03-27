package domain.result;

import java.util.ArrayList;
import java.util.List;

public class LottoResults {
    private List<LottoResult> lottoResults = new ArrayList<>();

    public void addResult(LottoResult lottoResult) {
        lottoResults.add(lottoResult);
    }


}
