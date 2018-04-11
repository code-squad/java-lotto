package lotto.domain;

import lotto.Prize;

public interface PrizeEvaluator {

    boolean isMatch(LottoNumber lottoNumber, LottoNumber lastPrizeOfNumbers);

    int getCount();

    static long getMatchCount(LottoNumber lottoNumber, LottoNumber lastPrizeOfNumbers) {
        return lottoNumber.getEqualCount(lastPrizeOfNumbers);
    }


    class First implements PrizeEvaluator {

        @Override
        public boolean isMatch(LottoNumber lottoNumber, LottoNumber lastPrizeOfNumbers) {
            return Prize.FIRST.getMatchCount() == getMatchCount(lottoNumber, lastPrizeOfNumbers);
        }

        @Override
        public int getCount() {
            return Prize.FIRST.getMatchCount();
        }
    }

    class Second implements PrizeEvaluator {

        @Override
        public boolean isMatch(LottoNumber lottoNumber, LottoNumber lastPrizeOfNumbers) {
            return Prize.SECOND.getMatchCount() == getMatchCount(lottoNumber, lastPrizeOfNumbers);
        }

        @Override
        public int getCount() {
            return Prize.SECOND.getMatchCount();
        }
    }

    class Third implements PrizeEvaluator {

        @Override
        public boolean isMatch(LottoNumber lottoNumber, LottoNumber lastPrizeOfNumbers) {
            return Prize.THIRD.getMatchCount() == getMatchCount(lottoNumber, lastPrizeOfNumbers);
        }

        @Override
        public int getCount() {
            return Prize.THIRD.getMatchCount();
        }
    }

    class Fourth implements PrizeEvaluator {

        @Override
        public boolean isMatch(LottoNumber lottoNumber, LottoNumber lastPrizeOfNumbers) {
            return Prize.FOURTH.getMatchCount() == getMatchCount(lottoNumber, lastPrizeOfNumbers);
        }

        @Override
        public int getCount() {
            return Prize.FOURTH.getMatchCount();
        }
    }
}
