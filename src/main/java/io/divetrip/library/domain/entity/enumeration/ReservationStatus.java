package io.divetrip.library.domain.entity.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum ReservationStatus {
    WAITING("예약 대기"),
    REQUESTED("예약 신청"),
    CANCELED("예약 취소"),
    COMPLETED("예약 완료"),
    NO_SHOW("예약 부도");

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
