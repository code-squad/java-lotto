package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.joining;

public class Lotto {
    public static final int LOTTO_NUM = 6;
    private List<LottoNum> nums;

    public Lotto(List<LottoNum> nums) {
        if (isInvalidNumberLength(nums.size())) {
            throw new IllegalArgumentException("길이를 확인해주세요 (" + LOTTO_NUM + "개 입력해야함)");
        }
        if (isIncludeDuplicateNumber(nums)) {
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }

        this.nums = nums;
    }

    private static boolean isInvalidNumberLength(int length) {
        return LOTTO_NUM != length;
    }

    private static boolean isIncludeDuplicateNumber(List<LottoNum> nums) {
        Set<LottoNum> numberPots = new HashSet<>(nums);
        return numberPots.size() != nums.size();
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

    public String getSavableLottoNumber() {
        return unfoldNumbers();
    }
}
