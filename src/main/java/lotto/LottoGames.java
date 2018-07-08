package lotto;

import java.util.List;
import java.util.Map;

public class LottoGames {
    public static final int LOTTO_PRICE_PER_TICKET = 1000;

    Lottos lottos;
    WinLotto winLotto;

    public LottoGames(long buyAmt, String[] manualNumbers) {
        lottos = new Lottos();
        checkPriceValidation(buyAmt);
        long ticketCounts = buyAmt / LOTTO_PRICE_PER_TICKET;
        lottos.addLottos(LottoMachine.buyManually(manualNumbers));
        lottos.addLottos(LottoMachine.buyAutomatic(ticketCounts - manualNumbers.length));
    }


    public void addSingleLotto(String lottoNumbers) {
        lottos.add(new Lotto(lottoNumbers));
    }

    public int getHavingCount() {
        return lottos.getLottosCount();
    }


    private void checkPriceValidation(long price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException();
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
