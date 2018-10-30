package domain;

import vo.LottoNoFactory;

public class AutoLottoBundleFactory implements LottoBundleFactory {

    @Override
    public LottoBundle generate(int count) {
        LottoBundle autoLottoBundle = new LottoBundle();
        for(int i = 0; i < count; i++){
            autoLottoBundle.add(generateRandomLotto());
        }
        return autoLottoBundle;
    }

    private Lotto generateRandomLotto(){
        return new Lotto(LottoNoFactory.getRandomMultiLottoNo());
    }

}
