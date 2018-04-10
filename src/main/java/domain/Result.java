package domain;

import Util.Database;

import java.sql.PreparedStatement;
import java.util.Map;

public class Result {
    private static final Double PERCENT = 100.0;

    // 클래스의 필드가 iterable dataStructure일 때는 handlebar에서 어떻게 처리해줄까
    private Map<Rank, Integer> result;
    private Integer rateOfProfit;

    public Result(Map<Rank, Integer> result, int payment) {
        this.result = result;
        rateOfProfit = calcRateOfProfit(payment);
    }

    public int calcRateOfProfit(int payment) {
        int total = 0;
        for (Rank rank : Rank.values()) {
            total = total + rank.isTotalPrize(result.get(rank));
        }
        Double result = total * (PERCENT / payment);
        return result.intValue();
    }

    public void insertResult() throws Exception {
        String sql = "insert into RESULT(FIRST, SECOND, THIRD, FOURTH, FIFTH, RATE) values (?,?,?,?,?,?)";
        PreparedStatement pstmt = Database.getConnection().prepareStatement(sql);
        //각 랭크의 회수를 저장하려고 하는 중.
        int index = 1;
        for (Rank rank : Rank.values()) {
            pstmt.setInt(index, this.result.get(rank));
            index++;
        }
        pstmt.setInt(6, rateOfProfit);
        pstmt.executeUpdate();
    }

    public Map<Rank, Integer> getResult() {
        return this.result;
    }

    public int getFirst() {
        return result.get(Rank.FIRST);
    }

    public int getSecond() {
        return result.get(Rank.SECOND);
    }

    public int getThird() {
        return result.get(Rank.THIRD);
    }

    public int getFourth() {
        return result.get(Rank.FOURTH);
    }

    public int getFifth() {
        return result.get(Rank.FIFTH);
    }

    public int getRate() {
        return rateOfProfit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n당첨통계\n");
        sb.append("---------\n");
        sb.append("3개 일치 (5000원)-" + result.get(Rank.FIFTH) + "개\n");
        sb.append("4개 일치 (50000원)-" + result.get(Rank.FOURTH) + "개\n");
        sb.append("5개 일치 (1500000원)-" + result.get(Rank.THIRD) + "개\n");
        sb.append("5개 일치, 보너스볼 일치 (30000000원)-" + result.get(Rank.SECOND) + "개\n");
        sb.append("6개 일치 (2000000000원)-" + result.get(Rank.FIRST) + "개\n");
        sb.append("총 수익률은 " + rateOfProfit + "%입니다.\n");
        return sb.toString();
    }
}