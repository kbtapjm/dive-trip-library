package io.divetrip.domain.entity;

import io.divetrip.domain.entity.auditing.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TRIP_SCHEDULE")
public class TripSchedule extends BaseEntity {

    /* 여행 일정 ID */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "trip_schedule_id", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID tripScheduleId;

    /* 여행 일자 */
    @Column(name = "trip_date", nullable = false)
    @JdbcTypeCode(SqlTypes.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tripDate;

    /* 여행 여정 */
    @Column(name = "itinerary", nullable = false, length = 500)
    private String itinerary;

    /* 여행 ID */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id", nullable = false, insertable = true, updatable = true)
    private Trip trip;

}
