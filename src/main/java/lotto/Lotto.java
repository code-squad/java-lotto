package lotto;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Lotto {
    public static final int LOTTO_PRICE_PER_TICKET = 1000;

    List<List<Integer>> havingLottos;

    public Lotto(){
        havingLottos = new ArrayList<>();
    }

    //테스트용
    List<List<Integer>> addSingleTicket(List<Integer> addLotto){
        havingLottos.add(addLotto);
        return havingLottos;
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
            havingLottos.add(generateSigleTicket());
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

    public List<Integer> generateSigleTicket() {
        List<Integer> candidateNumbers = new ArrayList<>();

        for(int i=0; i<45; i++){
            candidateNumbers.add(i+1);
        }

        Collections.shuffle(candidateNumbers);
        List<Integer> subList = candidateNumbers.subList(0, 6);
        Collections.sort(subList);

        return subList;
    }

    public List<List<Integer>> getHavingLottos() {
        return havingLottos;
    }

    public List<Integer> makeWinNumbersFromString(String winString) {
        List<Integer> winNumbers = new ArrayList<>();
        String[] winStringNumbers = winString.split(",");
        if(winStringNumbers.length != 6){
            throw new IllegalArgumentException();
        }

        for(String winToken:winStringNumbers){
            winNumbers.add(Integer.parseInt(winToken.trim()));
        }

        for(int i=0; i<winNumbers.size()-1; i++) {
            if( winNumbers.subList(i+1, winNumbers.size() ).contains(winNumbers.get(i)) ) {
                throw new IllegalArgumentException();
            }
        }

        return winNumbers;
    }

    public int getMatchSingleTicketCount(List<Integer> singleTicket, String winString) {
        int winCount = 0;
        List<Integer> winNumbers = makeWinNumbersFromString(winString);
        for(Integer winNumber:winNumbers) {
            if( singleTicket.contains(winNumber) ){
                winCount++;
            }
        }
        return winCount;
    }


    public Map<Integer,Integer> getWinnerMap(String winString) {
        Map<Integer,Integer> winnerMap = new HashMap<>();

        for(List<Integer> singleTicket : havingLottos) {
            Integer matchCount = getMatchSingleTicketCount( singleTicket, winString );
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
