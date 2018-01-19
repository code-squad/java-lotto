package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class ManualLottoNumberMakerTest {

  private ManualLottoNumberMaker manualLottoNumberMaker;

  @Before
  public void setUp() throws Exception {
    manualLottoNumberMaker = new ManualLottoNumberMaker();
    manualLottoNumberMaker.addManualNumber("1,2,3,4,5,6");
    manualLottoNumberMaker.addManualNumber("11,12,13,14,15,16");
    manualLottoNumberMaker.addManualNumber("21,22,23,24,25,26");
    manualLottoNumberMaker.addManualNumber("31,32,33,34,35,36");
  }

  @Test
  public void stack_테스트() throws Exception {
    Stack<String> stack = new Stack<>();
    stack.add("a");
    stack.add("b");
    stack.add("c");
    stack.add("d");

    assertEquals(4, stack.size());
    assertEquals("d", stack.pop());
    assertEquals("c", stack.pop());
    assertEquals("b", stack.pop());
    assertEquals(1, stack.size());
    assertEquals("a", stack.peek());
    assertEquals(1, stack.size());
  }

  @Test
  public void 수동_번호_발급() throws Exception {
    assertEquals("[31, 32, 33, 34, 35, 36]", manualLottoNumberMaker.issueLottoNumbers().toString());
    assertEquals("[21, 22, 23, 24, 25, 26]", manualLottoNumberMaker.issueLottoNumbers().toString());
    assertEquals("[11, 12, 13, 14, 15, 16]", manualLottoNumberMaker.issueLottoNumbers().toString());
    assertEquals("[1, 2, 3, 4, 5, 6]", manualLottoNumberMaker.issueLottoNumbers().toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void 수동_번호_발급_오류_생성한_로또수를초과하는경우() throws Exception {
    IntStream.iterate(1, i -> i + 1)
        .limit(manualLottoNumberMaker.getManualNumberCnt() + 1)
        .forEach(i -> manualLottoNumberMaker.issueLottoNumbers());
  }
}
