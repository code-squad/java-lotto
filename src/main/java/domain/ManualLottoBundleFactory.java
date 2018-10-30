package domain;

import util.StringParser;
import vo.LottoNoFactory;

import java.util.List;
import java.util.Set;

public class ManualLottoBundleFactory implements LottoBundleFactory {
    private List<String> lottoTexts;

    public ManualLottoBundleFactory(List<String> lottoTexts) {
        this.lottoTexts = lottoTexts;
    }

    @Override
    public LottoBundle generate(int count) {
        if(count != this.lottoTexts.size()) throw new IllegalArgumentException();
        LottoBundle manualLottoBundle = new LottoBundle();
        for (String lottoText : lottoTexts) {
            manualLottoBundle.add(generateTheLotto(StringParser.parseToNumbers(lottoText)));
        }
        return manualLottoBundle;
    }

    private Lotto generateTheLotto(Set<Integer> numbers){
        return new Lotto(LottoNoFactory.getMultiLottoNo(numbers));
    }

}
