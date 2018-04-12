import java.util.*;

public class LottoView {
    public static void announceMyCards(List<Card> cards){
        for (Card card : cards){
            System.out.println(card.getNumbers());
        }
    }
    public static void echoLuckyNumbers(Collection<String> source){
        String result = String.join(", ", source);
        System.out.println(result);
    }

    public static void announceResult(List<Integer> result, int budget){

        int benefit = 0;
        for (int i=3; i<7; i++){
            //6개 일치가 1개
            int count = Collections.frequency(result, i);
            System.out.println(makeSentence(i, count, getPrize(i)));
            benefit += count*getPrize(i);
        }

        System.out.println("투자금:"+budget+", 수익:"+ benefit);
        System.out.println("총 수익률은 "+((benefit-budget)/budget)*100 + "% 입니다");
        //TODO: 총 수익률 표시

    }
    private static int getPrize(int numOfOccurence){
        List<Integer> winnerPrize = Arrays.asList(5000, 50000, 150000, 2000000000);
        return winnerPrize.get(numOfOccurence - 3);
    }

    private static String makeSentence(int numOccurence, int count, int prize){
        StringBuilder sb = new StringBuilder();
        sb.append(numOccurence);
        sb.append("개 일치");
        sb.append(prize);
        sb.append("원:");
        sb.append(count);
        sb.append("개");

        return sb.toString();
    }
}
