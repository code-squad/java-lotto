package lotto;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class LottoGames {
    public static final int LOTTO_PRICE_PER_TICKET = 1000;

    Lottos lottos;
    WinLotto winLotto;

    public LottoGames(){
        lottos = new Lottos();
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

    public void addSingleLotto(String lottoNumbers){
        lottos.add(new Lotto(lottoNumbers));
    }

    WinLotto getWinLotto(){
        return winLotto;
    }

    public int getHavingCount(){
        return lottos.getLottosCount();
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

            lottos.add(new Lotto(numbers));
        }
    }

    private void checkPriceValidation(String price) {
        checkIsNotNullAndIsNumber(price);

        int priceAmt = Integer.parseInt(price);

        if(priceAmt % 1000 != 0){
            throw new IllegalArgumentException();
        }
    }


    public void setWinnerLotto(String winString, String bonusNumber) {
        checkIsNotNullAndIsNumber(bonusNumber);

        winLotto = new WinLotto(new Lotto(winString), Integer.parseInt(bonusNumber));
    }

    private void checkIsNotNullAndIsNumber(String inputNumber) {
        if(inputNumber == null || inputNumber.isEmpty() || inputNumber.trim().isEmpty()){
            throw new IllegalArgumentException();
        }

        if(!StringUtils.isNumeric(inputNumber)){
            throw new IllegalArgumentException();
        }
    }


    public Map<Rank, Integer> getRankMap(){

        return lottos.makeRankCountMap(winLotto);
    }


    public Lottos getLottos() {
        return lottos;
    }
}
