package lotto.view;

import lotto.domain.Order;
import lotto.dto.WinningDTO;
import lotto.type.WinningType;


public class ResultView {
    public static void printLottos(Order order){
        int custom = order.countOfCustomLotto();
        int auto = order.countOfLotto() - custom;

        System.out.println("수동으로 "+custom+"개, 자동으로 "+auto+"개를 구매했습니다.");
        order.getLottos()
                .stream()
                .forEach(System.out::println);

    }

    public static void printWinningResult(WinningDTO winningResult){
        for(WinningType type : WinningType.values()){
            if(type.equals(WinningType.NONE)){
                continue;
            }

            System.out.println(type.getDescription()+" - "+winningResult.getWinningCount(type)+"개");
        }
        System.out.println("총 수익률은 "+String.format("%,d", winningResult.getEarningsRate())+"%입니다.");
    }

}
