package io.divetrip.domain.entity.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum PaymentStatus {
    WAITING("결제 대기"),
    REQUESTED("결제 신청"),
    CANCELED("결제 취소"),
    FAILED("결제 실패"),
    COMPLETED("결제 완료");

    private final String description;

    private static final Map<String, PaymentStatus> valueAndPaymentStatusMap = new HashMap<>();

    static {
        for (PaymentStatus paymentStatus : PaymentStatus.values()) {
            valueAndPaymentStatusMap.put(paymentStatus.toString(), paymentStatus);
        }
    }

    public static PaymentStatus findByValue(final String value) {
        return valueAndPaymentStatusMap.get(value);
    }
}
