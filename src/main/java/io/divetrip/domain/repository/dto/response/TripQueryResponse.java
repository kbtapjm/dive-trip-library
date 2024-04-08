package io.divetrip.domain.repository.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import io.divetrip.domain.entity.enumeration.TripStatus;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class TripQueryResponse {
    /* 여행 ID */
    private UUID tripId;

    /* 여행 상태 */
    private TripStatus tripStatus;

    /* 출발 시간 */
    private LocalDateTime departureTime;

    /* 반환 시간 */
    private LocalDateTime returnTime;

    /* 시작 포트 */
    private String startPort;

    /* 종료 포트 */
    private String endPort;

    /* 기간 */
    private String durations;

    /* 다이빙 횟수 */
    private Integer totalDives;

    /* 등록자 */
    private String createdBy;

    /* 등록일 */
    private LocalDateTime createdAt;

    /* 수정자 */
    private String updatedBy;

    /* 수정일 */
    private LocalDateTime updatedAt;

    @QueryProjection
    public TripQueryResponse(UUID tripId, TripStatus tripStatus, LocalDateTime departureTime, LocalDateTime returnTime, String startPort, String endPort, String durations, Integer totalDives, String createdBy, LocalDateTime createdAt, String updatedBy, LocalDateTime updatedAt) {
        this.tripId = tripId;
        this.tripStatus = tripStatus;
        this.departureTime = departureTime;
        this.returnTime = returnTime;
        this.startPort = startPort;
        this.endPort = endPort;
        this.durations = durations;
        this.totalDives = totalDives;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
    }
}
