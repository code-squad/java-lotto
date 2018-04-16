//package com.codesquad.lotto.view;
//
//import com.codesquad.lotto.domain.LottoBundle;
//
//import java.util.List;
//import java.util.Objects;
//
//public class LottoReceiptPresentationModel {
//
//    final LottoBundle bundle;
//
//    public LottoReceiptPresentationModel(final LottoBundle bundle) {
//        this.bundle = bundle;
//    }
//
//    public String countMessage() {
//        return String.format("%d개를 구매했습니다.", bundle.count());
//    }
//
//    public String lottoList() {
//        final List<String> list = bundle.lotteriesString();
//        return String.join("\r\n", list);
//    }
//
//    @Override
//    public boolean equals(final Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        final LottoReceiptPresentationModel that = (LottoReceiptPresentationModel) o;
//        return Objects.equals(bundle, that.bundle);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(bundle);
//    }
//}
