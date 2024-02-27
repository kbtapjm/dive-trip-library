package io.divetrip.domain.repository.dto.request;

import io.divetrip.domain.entity.enumeration.Continent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class DestinationQueryRequest {
    /* 대륙 */
    private Continent continent;

    /* 지역 */
    private String area;

    /* 국가 ID */
    private Long countryId;
}
