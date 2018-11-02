package lottogame.dao;

import lottogame.domain.Lotto;
import lottogame.domain.PrizeRank;
import lottogame.dto.Result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoDao {
    private static final String URL = "jdbc:mysql://207.148.110.44:3306/codesquad";
    private static final String USER = "nnn";
    private static final String PASSWORD = "nnn";
    private static final String SELECT_QUERY = "SELECT * FROM lotto";
    private static final String INSERT_QUERY = "INSERT INTO lotto VALUE(?)";
    private static final String INSERT_RESULT = "INSERT INTO result value(?,?,?,?,?)";
    private static final String LOTTO_COLUMN = "numbers";

    public void insertLotto(List<Lotto> lottos) {
        List<String> stringLottos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            stringLottos.add(lotto.toString());
        }
        insert(String.join(System.lineSeparator(),stringLottos));
    }

    public List<Lotto> selectLotto() {
        return Arrays.stream(select().split("\r?\n"))
                .map(Lotto::ofText)
                .collect(Collectors.toList());
    }

    private Boolean insert(String value) {
        return Template.exceptionHandle((sqlSet) -> {
            sqlSet.makeConnection(URL, USER, PASSWORD);
            sqlSet.prepareStatement(INSERT_QUERY);
            sqlSet.setString(1, value);
            return sqlSet.execute();
        });
    }

    private String select() {
        return Template.exceptionHandle((sqlSet) -> {
            sqlSet.makeConnection(URL, USER, PASSWORD);
            sqlSet.prepareStatement(SELECT_QUERY);
            sqlSet.executeQuery();
            return sqlSet.getFirst(LOTTO_COLUMN);
        });
    }

    public Boolean insertResult(Result result) {
        return Template.exceptionHandle((sqlSet) -> {
            sqlSet.makeConnection(URL, USER, PASSWORD);
            sqlSet.prepareStatement(INSERT_RESULT);
            sqlSet.setInt(1, result.get(PrizeRank.NO_MISS));
            sqlSet.setInt(2, result.get(PrizeRank.ONE_MISS_BONUS_HIT));
            sqlSet.setInt(3, result.get(PrizeRank.ONE_MISS));
            sqlSet.setInt(4, result.get(PrizeRank.TWO_MISS));
            sqlSet.setInt(5, result.get(PrizeRank.THREE_MISS));
            return sqlSet.execute();
        });
    }
}

