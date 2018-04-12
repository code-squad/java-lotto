import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final int cardPrice = 1000;
    private List<Card> cards;

    public Lotto(int budget) {
        this.cards = LottoGenerator.buyCards(budget/cardPrice);
    }
    public List<Card> getCards(){
        return this.cards;
    }
    public List<Integer> getResult(List<Integer> luckyNumber){
        List<Card> cards = getCards();
        List<Integer> howManyMatch = new ArrayList<>();
        for (Card card : cards){
            howManyMatch.add(card.numMatchLuckNumber(luckyNumber));
        }
        return howManyMatch;
    }
}
