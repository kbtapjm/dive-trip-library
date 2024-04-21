package io.divetrip.domain.entity.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum ReservationStatus {
    RESERVATION_WAITING("예약 대기 중"),
    RESERVATION_REQUESTED("예약 신청"),
    PAYMENT_COMPLETED("결제 완료"),
    PAYMENT_CANCELED("결제 취소"),
    RESERVATION_CANCELED("예약 취소"),
    RESERVATION_NO_SHOW("예약 부도")
    ;

    private final String description;

    private static final Map<String, ReservationStatus> valueAndReservationStatusMap = new HashMap<>();

    static {
        for (ReservationStatus reservationStatus : ReservationStatus.values()) {
            valueAndReservationStatusMap.put(reservationStatus.toString(), reservationStatus);
        }
    }

    public static ReservationStatus findByValue(final String value) {
        return valueAndReservationStatusMap.get(value);
    }
}
