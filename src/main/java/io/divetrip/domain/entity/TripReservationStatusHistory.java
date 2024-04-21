package io.divetrip.domain.entity;

import io.divetrip.domain.entity.auditing.BaseEntity;
import io.divetrip.domain.entity.enumeration.ReservationStatus;
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

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "trip_reservation_status_history")
public class TripReservationStatusHistory extends BaseEntity {

    /* 여행 예약 상태 이력 ID */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "trip_reservation_status_history_id", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID tripReservationStatusHistoryId;

    /* 예약 상태 */
    @Column(name = "reservation_status", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    /* 비고 */
    @Column(name = "note", length = 500)
    private String note;

    /* 여행 예약 ID */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_reservation_id", nullable = false, insertable = true, updatable = true)
    private TripReservation tripReservation;

}
