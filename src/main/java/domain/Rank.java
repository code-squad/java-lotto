package domain;

public enum Rank {
  FIRST(6, 2000000000),
  SECOND(5, 1500000),
  THIRD(4, 50000),
  FOURTH(3, 5000);

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
}
