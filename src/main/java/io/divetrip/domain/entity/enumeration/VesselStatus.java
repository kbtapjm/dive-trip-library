package io.divetrip.domain.entity.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum VesselStatus {
    WAITING("대기 중"),
    OPERATING("운영 중"),
    UNDER_REPAIRING("수리 중"),
    NOT_OPERATING("미 운영");

    private final String description;

    private static final Map<String, VesselStatus> valueAndVesselStatusMap = new HashMap<>();

    static {
        for (VesselStatus VesselStatus : VesselStatus.values()) {
            valueAndVesselStatusMap.put(VesselStatus.toString(), VesselStatus);
        }
    }
    public static VesselStatus findByValue(final String value) {
        return valueAndVesselStatusMap.get(value);
    }

}
