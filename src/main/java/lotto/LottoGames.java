package lotto;

import java.util.List;
import java.util.Map;

public class LottoGames {
    public static final int LOTTO_PRICE_PER_TICKET = 1000;

    Lottos lottos;
    WinLotto winLotto;

    public LottoGames(long buyAmt, String[] manualNumbers) {
        lottos = new Lottos();
        checkPriceValidation(buyAmt, manualNumbers);
        long ticketCounts = buyAmt / LOTTO_PRICE_PER_TICKET;
        lottos.addLottos(LottoGenerator.buyManually(manualNumbers));
        lottos.addLottos(LottoGenerator.buyAutomatic(ticketCounts - manualNumbers.length));
    }


    public void addSingleLotto(String lottoNumbers) {
        lottos.add(new Lotto(lottoNumbers));
    }

    public int getHavingCount() {
        return lottos.getLottosCount();
    }


    private void checkPriceValidation(long price, String[] manualNumbers) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("금액이상. 1000 단위로 입력가능해야합니다.");
        }

        if (price / 1000 < manualNumbers.length) {
            throw new IllegalArgumentException("금액이상. 구매금액 : " + price + " 수동구매수량 : " + manualNumbers.length);
        }
    }


    public void setWinLotto(List<String> winNumbers) {
        winLotto = new WinLotto(new Lotto(winNumbers.get(0)), Integer.parseInt(winNumbers.get(1)));
    }


    public Map<Rank, Integer> getRankMap() {
        return lottos.makeRankCountMap(winLotto);
    }


    public Lottos getLottos() {
        return lottos;
    }
}
