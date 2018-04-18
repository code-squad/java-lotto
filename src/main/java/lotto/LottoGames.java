package lotto;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class LottoGames {
    public static final int LOTTO_PRICE_PER_TICKET = 1000;

    Lottos lottos;
    WinLotto winLotto;

    public LottoGames(long buyAmt, String [] manualNumbers){
        lottos = new Lottos();

        checkPriceValidation(buyAmt);
        long ticketCounts = buyAmt / LOTTO_PRICE_PER_TICKET;
        buyManually(manualNumbers);
        buyLottoNCounts(ticketCounts - manualNumbers.length);

    }

    private void buyManually(String[] manualNumbers){
        for(String manualNumber : manualNumbers){
            lottos.add(new Lotto(manualNumber));
        }
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

    void buyLottoNCounts(long ticketCounts) {
        for(int i=0; i<ticketCounts; i++){
            List<String> randomNumbers = generateRandomLottoNumbers();
            String numbers = String.join(", ", randomNumbers.toArray(new String[randomNumbers.size()]) );

            lottos.add(new Lotto(numbers));
        }
    }

    private void checkPriceValidation(long price) {

        if(price % 1000 != 0){
            throw new IllegalArgumentException();
        }
    }


    public void setWinnerLotto(List<String> winNumbers) {
        checkIsNotNullAndIsNumber(winNumbers.get(1));
        winLotto = new WinLotto(new Lotto(winNumbers.get(0)), Integer.parseInt(winNumbers.get(1)));
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
