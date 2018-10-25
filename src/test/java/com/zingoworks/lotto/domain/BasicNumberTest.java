//package com.zingoworks.generateAutomaticLotto.domain;
//
//import org.junit.Test;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//public class BasicNumberTest {
//
//    @Test
//    public void 기본넘버세트생성_개수확인() {
//        assertThat(BasicNumber.getBasicNumberSet().size()).isEqualTo(45);
//    }
//
//    @Test
//    public void 기본넘버세트생성_중복유무확인() {
//        List<Integer> temp = BasicNumber.getBasicNumberSet();
//        Set<Integer> verify = new HashSet<>();
//        for (Integer integer : temp) {
//            verify.add(integer);
//        }
//        assertThat(verify.size()).isEqualTo(45);
//    }
//
//    @Test
//    public void 기본넘버세트생성_출력() {
//        System.out.println(BasicNumber.getBasicNumberSet());
//    }
//
//}