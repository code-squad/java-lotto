package domain;

import domain.exceptions.DuplicatedBallException;

import java.util.List;

public class WinningLotto extends Lotto {

    private Ball bonusBall;

    private WinningLotto(List<Integer> numbers, Ball bonusBall) {
        super(numbers);
        if (!isValidBonusBall(numbers, bonusBall)) {
            throw new DuplicatedBallException("중복된 번호는 넣을 수 없습니다.");
        }
        this.bonusBall = bonusBall;
    }

    public static WinningLotto of(List<Integer> numbers, Ball bonusBall) {
        return new WinningLotto(numbers, bonusBall);
    }

    static boolean isValidBonusBall(List<Integer> numbers, Ball bonusBall) {
        return !bonusBall.isContainedIn(numbers);
    }

    public boolean isBonus(List<Ball> balls) {
        return balls.contains(bonusBall);
    }

}
