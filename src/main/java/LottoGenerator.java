import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public static List<Card> buyCards(int numCard){
        List<Card> cards = new ArrayList<>();
        for (int i =0; i<numCard; i++){
            cards.add(new Card(pickSixNumbers(shuffleCardNumbers(createLottoValidNumbers(45)))));
        }
        return cards;
    }
    public static List<Integer> createLottoValidNumbers(int maxNum){
        List<Integer> numberPool = IntStream.rangeClosed(1, maxNum)
                .boxed().collect(Collectors.toList());
        return numberPool;
    }

    public static List<Integer> shuffleCardNumbers(List<Integer> lottoValidNumber){
        Collections.shuffle(lottoValidNumber);
        return lottoValidNumber;
    }

    public static List<Integer> pickSixNumbers(List<Integer> source){
        return source.subList(0, 6);
    }

}
