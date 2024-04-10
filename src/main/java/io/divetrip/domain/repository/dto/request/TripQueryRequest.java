package io.divetrip.domain.repository.dto.request;

import io.divetrip.domain.entity.enumeration.TripStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class TripQueryRequest {
    /* 여행 상태 */
    private TripStatus tripStatus;

    /* 지역 */
    private String area;
}
