package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinLotto;

import java.util.Arrays;
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
        if(manualNumbers.length > 0) {
            lottos.addLottos(LottoGenerator.buyManually(manualNumbers));
        }
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

    public int getAwardAmt(){
        List<Rank> ranks = Arrays.asList(Rank.values());
        Map<Rank, Integer> rankCountMap = getRankMap();
        int awardAmt = 0;

        for(Rank rank : ranks){
            if(rankCountMap.get(rank) > 0) {
                awardAmt += rank.getWinningMoney();
            }
        }

        return awardAmt;
    }


    public Lottos getLottos() {
        return lottos;
    }
}
