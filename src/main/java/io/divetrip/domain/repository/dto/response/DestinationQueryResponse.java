package io.divetrip.domain.repository.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import io.divetrip.domain.entity.enumeration.Continent;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class DestinationQueryResponse {
    /* 목적지 ID */
    private UUID destinationId;

    /* 대륙 */
    private Continent continent;

    /* 지역 */
    private String area;

    /* 설명 */
    private String description;

    /* 국가 ID */
    private Long countryId;

    /* ISO */
    private String iso;

    /* 국가 명 */
    private String countryName;

    /* 등록자 */
    private String createdBy;

    /* 등록일 */
    private LocalDateTime createdAt;

    /* 수정자 */
    private String updatedBy;

    /* 수정일 */
    private LocalDateTime updatedAt;

    @QueryProjection
    public DestinationQueryResponse(UUID destinationId, Continent continent, String area, String description, Long countryId, String iso, String countryName, String createdBy, LocalDateTime createdAt, String updatedBy, LocalDateTime updatedAt) {
        this.destinationId = destinationId;
        this.continent = continent;
        this.area = area;
        this.description = description;
        this.countryId = countryId;
        this.iso = iso;
        this.countryName = countryName;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
