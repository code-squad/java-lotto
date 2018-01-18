package domain;

import java.util.Arrays;

public enum Rank {
  FIRST(6, 2000000000),
  SECOND(5, 30000000),
  THIRD(5, 1500000),
  FOURTH(4, 50000),
  FIFTH(3, 5000),
  ZERO(0, 0);

  private int matchOfNumberCnt;
  private int winningMoney;

  Rank(int matchOfNumberCnt, int winningMoney) {
    this.matchOfNumberCnt = matchOfNumberCnt;
    this.winningMoney = winningMoney;
  }

  public int getMatchOfNumberCnt() {
    return matchOfNumberCnt;
  }

  public int getWinningMoney() {
    return winningMoney;
  }

  public boolean isEqualMatchOfNumberCnt(int matchOfNumberCnt) {
    return this.matchOfNumberCnt == matchOfNumberCnt;
  }

  public static Rank valueOf(int matchOfNumberCnt, boolean matchBonus) {
    if (SECOND.isEqualMatchOfNumberCnt(matchOfNumberCnt) && matchBonus) {
      return SECOND;
    }

    Rank rank = Arrays.stream(Rank.values())
        .filter(r -> r != SECOND)
        .filter(r -> r.isEqualMatchOfNumberCnt(matchOfNumberCnt))
        .findFirst().orElse(ZERO);
    return rank;
  }
}
