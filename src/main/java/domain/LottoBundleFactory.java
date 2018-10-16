package domain;

public class LottoBundleFactory {
    public static LottoBundle generateRandomLottoBundle(int count){
        LottoBundle randomLottoBundle = new LottoBundle();
        for(int i = 0; i < count; i++){
            randomLottoBundle.add(LottoFactory.generateRandomLotto());
        }
        return randomLottoBundle;
    }
}
