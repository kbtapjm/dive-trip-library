package io.divetrip.domain.entity;

import io.divetrip.domain.entity.auditing.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "TRIP_LODGING")
public class TripLodging extends BaseEntity {

    /* 여행 숙소 ID */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "trip_lodging_id", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID tripLodgingId;

    /* 선박 선실 ID */
    @Column(name = "vessel_cabin_id", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID vesselCabinId;

    /* 수용 인원 */
    @Column(name = "capacity", nullable = false, length = 2)
    private Integer capacity;

    /* 선실 가격 */
    @Column(name = "cabin_price", nullable = false, length = 10)
    private Integer cabinPrice;

    /* 비고 */
    @Column(name = "note", length = 500)
    private String note;

    /* 여행 ID */
    @Column(name = "trip_id", nullable = false)
    private UUID tripId;

}
