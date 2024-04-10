package io.divetrip.domain.entity.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum TripStatus {
    WAITING("대기"),
    RESERVATION("예약중"),
    CLOSED("마감"),
    CANCELED("취소"),
    DONE("완료"),
    ;

    private final String description;

    private static final Map<String, TripStatus> valueAndTripStatusMap = new HashMap<>();

    static {
        for (TripStatus tripStatus : TripStatus.values()) {
            valueAndTripStatusMap.put(tripStatus.toString(), tripStatus);
        }
    }

    public static TripStatus findByValue(final String value) {
        return valueAndTripStatusMap.get(value);
    }

}
