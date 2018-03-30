package domain;

import domain.result.LottoNum;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Lotto {
    public static final int LOTTO_NUM = 6;
    private List<LottoNum> nums;

    public Lotto(List<LottoNum> nums) {
        if (isInvalidNumberLength(nums.size())) {
            throw new IllegalArgumentException("길이를 확인해주세요 (" + LOTTO_NUM + "개 입력해야함)");
        }
        this.nums = nums;
    }

    private static boolean isInvalidNumberLength(int length) {
        return LOTTO_NUM != length;
    }

    public int match(Lotto otherLotto) {
        int matchCount = 0;
        for (LottoNum num : otherLotto.nums) {
            if (nums.contains(num)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean isContainNumber(LottoNum num) {
        return nums.stream().anyMatch(lottoNum -> lottoNum.equals(num));
    }

    @Override
    public String toString() {
        return "[" + unfoldNumbers() + "]";
    }

    private String unfoldNumbers() {
        Collections.sort(nums);
        return nums.stream().map(Object::toString).collect(joining(", "));
    }
}
