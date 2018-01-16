package domain;


import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private static final int LOTTO_PRICE = 1000;

    public static List<Lotto> buyLotto(BuyInfo buyInfo, LottoNumberCreationStrategy lottoNumberCreationStrategy) {
        List<Lotto> lottos = buyInfo.addManualLotto(LOTTO_PRICE);
        int quantity = buyInfo.getPurchasableQuantity(LOTTO_PRICE);

        for(int i = 0 ; i < quantity ; ++i)
            lottos.add(new Lotto(lottoNumberCreationStrategy));

        return lottos;
    }

    /*
    lottos리스트를 넘겨서 buyInfo에서 추가하는게 맞는걸까?
    객체지향적으로 생각하면 로또 생성자가 수동 로또 번호(티켓)를 받아서 내부에서 처리해야하지 않을까?
    그런데 이렇게 하면 buyInfo내에 숫자 정보들을 반환하는 getNums()라는 getter가 생기게 됨..
     */
}
