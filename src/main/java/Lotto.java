import java.util.*;

public class Lotto {
    private final int CARD_PRICE = 1000;
    private List<Card> cards;
    private LottoResult lottoResult;
    private int budget;

    public Lotto(int budget) {
        this.budget = budget;
        this.cards = LottoGenerator.buyCards(budget/CARD_PRICE);
    }

    public List<Card> getCards(){
        return this.cards;
    }

    public LottoResult sendLuckyCard(Card luckyCard){
        List<Integer> numMatchResults = new ArrayList<>();
        for (Card card : getCards()){
            numMatchResults.add(card.numMatchLuckNumber(luckyCard));
        }
        Map<Integer, Integer> countMap = toMap(numMatchResults);
        return new LottoResult(countMap, calcBenefitRate(countMap));
    }

    private Map<Integer, Integer> toMap(List<Integer> hits){
        Map<Integer, Integer> result = new HashMap<Integer,Integer>();
        for (int i = 0; i<7; i++){
            int count = Collections.frequency(hits, i);
            result.put(i, count);
        }
        return result;
    }

    private int calcBenefitRate(Map<Integer, Integer> result){
        int benefit = 0;
        List<Integer> winnerPrize = Arrays.asList(0, 0, 0, 5000, 50000, 150000, 2000000000);
        for (int i=0; i<7; i++){
            benefit += result.get(i) * winnerPrize.get(i);
        }
        return (benefit/budget)*100;
    }
}
