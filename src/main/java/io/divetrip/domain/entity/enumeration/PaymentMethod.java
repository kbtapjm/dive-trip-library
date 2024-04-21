package io.divetrip.domain.entity.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum PaymentMethod {
    DIRECT_TRANSFER("직접 이체"),
    CREDIT_CARD("신용 카드")
    ;

    private final String description;

    private static final Map<String, PaymentMethod> valueAndPaymentMethodMap = new HashMap<>();

    static {
        for (PaymentMethod paymentMethod : PaymentMethod.values()) {
            valueAndPaymentMethodMap.put(paymentMethod.toString(), paymentMethod);
        }
    }

    public static PaymentMethod findByValue(final String value) {
        return valueAndPaymentMethodMap.get(value);
    }
}
