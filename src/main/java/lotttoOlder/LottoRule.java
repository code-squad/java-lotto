package lotttoOlder;

public enum LottoRule {
  FIRST(1, 6, 2_000_000_000),
  SECOND(2, 5, 1_500_000),
  THIRD(3, 4, 30_000_000),
  FOURTH(4, 3, 5_000);

  private int rank;
  private int matchNum;
  private int prize;

  public static final int LOTTO_PRICE = 1000;
  public static final int LOTTO_NUM_COUNT = 6;

  LottoRule(int rank, int matchNum, int prize) {
    this.rank = rank;
    this.matchNum = matchNum;
    this.prize = prize;
  }

  public int getRank() {
    return rank;
  }

  public int getMatchNum() {
    return matchNum;
  }

  public int getPrize() {
    return prize;
  }

  @Override
  public String toString() {
    return "LottoRule{}";
  }

}
