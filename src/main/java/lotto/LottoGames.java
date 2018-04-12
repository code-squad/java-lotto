package lotto;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class LottoGames {
    public static final int LOTTO_PRICE_PER_TICKET = 1000;
    private static final int MATCH_3 = 5000;
    private static final int MATCH_4 = 50000;
    private static final int MATCH_5 = 1500000;
    private static final int MATCH_6 = 2000000000;

    List<Lotto> havingLottos;
    Lotto winnerLotto;

    Map<Integer, Integer> rewardMap;

    public LottoGames(){
        havingLottos = new ArrayList<>();
        rewardMap = new HashMap<>();
        rewardMap.put(3, MATCH_3);
        rewardMap.put(4, MATCH_4);
        rewardMap.put(5, MATCH_5);
        rewardMap.put(6, MATCH_6);
    }

    private List<String> generateRandomLottoNumbers(){
        List<String> candidateNumbers = new ArrayList<>();
        List<String> lottoNumber;

        for(int i=0; i<45; i++){
            candidateNumbers.add(  (i+1) + "" );
        }

        Collections.shuffle(candidateNumbers);
        lottoNumber = candidateNumbers.subList(0, 6);
        Collections.sort(lottoNumber);
        return lottoNumber;
    }

    public List<Lotto> addSingleLotto(String lottoNumbers){
        havingLottos.add(new Lotto(lottoNumbers));
        return havingLottos;
    }

    Lotto getWinnerLotto(){
        return winnerLotto;
    }

    public Map<Integer, Integer> getRewardMap() {
        return rewardMap;
    }


    public int getHavingCount(){
        return havingLottos.size();
    }

    public void buy(String price) {
        checkPriceValidation(price);
        int ticketCounts = Integer.parseInt(price) / LOTTO_PRICE_PER_TICKET;
        buyLottoNCounts(ticketCounts);
    }

    void buyLottoNCounts(int ticketCounts) {
        for(int i=0; i<ticketCounts; i++){
            List<String> randomNumbers = generateRandomLottoNumbers();
            String numbers = String.join(", ", randomNumbers.toArray(new String[randomNumbers.size()]) );

            havingLottos.add(new Lotto(numbers));
        }
    }

    private void checkPriceValidation(String price) {
        if(price == null || price.isEmpty() || price.trim().isEmpty()){
            throw new IllegalArgumentException();
        }

        if(!StringUtils.isNumeric(price)){
            throw new IllegalArgumentException();
        }

        int priceAmt = Integer.parseInt(price);

        if(priceAmt % 1000 != 0){
            throw new IllegalArgumentException();
        }
    }


    public List<Lotto> getHavingLottos() {
        return havingLottos;
    }

    public void setWinnerLotto(String winString) {
        winnerLotto = new Lotto(winString);
    }

    public Map<Integer,Integer> getWinnerMap() {
        Map<Integer,Integer> winnerMap = new HashMap<>();

        for(Lotto lotto : havingLottos) {
            Integer matchCount = lotto.getMatchCount(winnerLotto);
            if (winnerMap.containsKey(matchCount)) {
                Integer existCount = winnerMap.get(matchCount);
                winnerMap.put(matchCount, existCount+1);
                continue;
            }
            winnerMap.put(matchCount, 1);
        }
        return winnerMap;

    }
}
