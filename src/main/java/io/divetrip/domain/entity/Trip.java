package io.divetrip.domain.entity;

import io.divetrip.domain.entity.auditing.BaseEntity;
import io.divetrip.domain.entity.enumeration.TripStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TRIP")
public class Trip extends BaseEntity {

    /* 여행 ID */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "trip_id", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID tripId;

    /* 여행 상태 */
    @Column(name = "trip_status", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private TripStatus tripStatus;

    /* 출발 시간 */
    @Column(name = "departure_time", nullable = false)
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime departureTime;

    /* 반환 시간 */
    @Column(name = "return_time", nullable = false)
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime returnTime;

    /* 시작 포트 */
    @Column(name = "start_port", nullable = false, length = 20)
    private String startPort;

    /* 종료 포트 */
    @Column(name = "end_port", nullable = false, length = 20)
    private String endPort;

    /* 기간 */
    @Column(name = "durations", nullable = false, length = 20)
    private String durations;

    /* 다이빙 횟수 */
    @Column(name = "total_dives", nullable = false, length = 2)
    private Integer totalDives;

    /* 목적지 ID */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_id", nullable = false, insertable = true, updatable = true)
    private Destination destination;

    /* 선박 */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vessel_id", nullable = false, insertable = true, updatable = true)
    private Vessel vessel;

}
