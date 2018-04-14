package lotto;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class LottoGames {
    public static final int LOTTO_PRICE_PER_TICKET = 1000;

    List<Lotto> havingLottos;
    WinLotto winLotto;

    public LottoGames(){
        havingLottos = new ArrayList<>();
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

    WinLotto getWinLotto(){
        return winLotto;
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
        checkIsNotNullAndIsNumber(price);

        int priceAmt = Integer.parseInt(price);

        if(priceAmt % 1000 != 0){
            throw new IllegalArgumentException();
        }
    }


    public List<Lotto> getHavingLottos() {
        return havingLottos;
    }

    public void setWinnerLotto(String winString, String bonusNumber) {
        checkIsNotNullAndIsNumber(bonusNumber);

        winLotto = new WinLotto(new Lotto(winString), Integer.parseInt(bonusNumber));
        setResultRank();
    }

    private void checkIsNotNullAndIsNumber(String inputNumber) {
        if(inputNumber == null || inputNumber.isEmpty() || inputNumber.trim().isEmpty()){
            throw new IllegalArgumentException();
        }

        if(!StringUtils.isNumeric(inputNumber)){
            throw new IllegalArgumentException();
        }
    }

    private void setResultRank(){
        for(Lotto lotto : havingLottos){
            lotto.setRank(winLotto);
        }
    }

    public Map<Rank, Integer> getRankMap(){
        Map<Rank, Integer> rankCountMap = new HashMap<>();
        rankCountMap.put(Rank.FIRST, 0);
        rankCountMap.put(Rank.SECOND, 0);
        rankCountMap.put(Rank.THIRD, 0);
        rankCountMap.put(Rank.FOURTH, 0);
        rankCountMap.put(Rank.FIFTH, 0);
        rankCountMap.put(Rank.MISS, 0);

        for(Lotto lotto : havingLottos){
            rankCountMap.put( lotto.getRank(), rankCountMap.get(lotto.getRank()) +1 );
        }

        return rankCountMap;
    }


}
