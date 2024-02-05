package io.divetrip.domain.repository.dto.request;

import io.divetrip.domain.entity.enumeration.VesselStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class VesselQueryRequest {
    /* 선박 명 */
    private String vesselName;

    /* 선박 상태 */
    private VesselStatus vesselStatus;

    /* 사용 여부 */
    private Boolean used;

}
