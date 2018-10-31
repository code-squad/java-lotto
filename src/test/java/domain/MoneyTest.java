package domain;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class MoneyTest {

    /* 머니 클래스 생성 -> 머니 클래스의 역할
        - 돈을 관리 o
        - 수익률 구하기 o
        - 남은돈 관리? x
        - input 에게 money 를 받는다. o
        - 머니가 로또 횟수를 줄까? x
        - 로또가 맞은 갯수를 구하면 머니에게 (번 금액과 맞은횟수 전달) 그럼 머니는 수익률을 산출 o
        - output에서 수익률을 달라하면 계산해서 내보내 준다. o
        - 머니보단 월렛이 낫지 않을까?// ??
        - 머니는 Manager 안에 있으면 좋을듯 매니져가 아우풋으로 계산값을 건내 주자 o

    */
    @Test
    public void 머니클래스생성() {
        // 머니 클래스는 현제 금액을 가지고 있다.
        Money money = Money.of(1000);
        assertThat(money.getMoney()).isEqualTo(1000);

    }

    @Test
    public void 머니증가태스트() {
        Money money = Money.of(1000);
        money.increase(50000 * 3);
        assertThat(money.getMoney()).isEqualTo(1000);
        assertThat(money.getNewMoney()).isEqualTo(150000);
    }

    @Test
    public void 수익률계산태스트() {
        Money money = Money.of(1000);
        money.increase(50000 * 3);
        assertThat(money.yield()).isEqualTo(50000 * 3 / 1000);
    }

    @Test
    public void 매니저와머니와연결태스트() {
        Money money = Money.of(1000);
        LottoryManager lottoryManager = LottoryManager.of(1000);
        // 2등의 카운트를 증가 시켰다.
        lottoryManager.increase(5, true);
        money.increase(Rank.TWO.multiplicationMoney(lottoryManager.findRank(Rank.TWO)));
        assertThat(money.yield()).isEqualTo(Rank.TWO.getMoney() / 1000);
    }


    @Test
    public void 메니져수익률태스트() {
        Money money = Money.of(1000);
        money.increase(50000 * 3);
        assertThat(money.yield()).isEqualTo(50000 * 3 / 1000  *100);

        LottoryManager lottoryManager = LottoryManager.of(1000);
        lottoryManager.increase(5, true);

    }
}
