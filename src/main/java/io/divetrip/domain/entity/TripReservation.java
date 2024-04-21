package io.divetrip.domain.entity;

import io.divetrip.domain.entity.auditing.BaseEntity;
import io.divetrip.domain.entity.enumeration.ReservationStatus;
import jakarta.persistence.CascadeType;
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
import jakarta.persistence.OneToMany;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TRIP_RESERVATION")
public class TripReservation extends BaseEntity {

    /* 여행 예약 ID */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "trip_reservation_id", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID tripReservationId;

    /* 예약 상태 */
    @Column(name = "reservation_status", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    /* 결제 여부 */
    @Column(name = "paid", nullable = false)
    @JdbcTypeCode(SqlTypes.BOOLEAN)
    private Boolean paid;

    /* 출발 편명 */
    @Column(name = "departure_flight_numbers", length = 20)
    private String departureFlightNumbers;

    /* 출발 시간 */
    @Column(name = "departure_flight_date")
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime departureFlightDate;

    /* 도착 편명 */
    @Column(name = "arrival_flight_numbers", length = 20)
    private String arrivalFlightNumbers;

    /* 도착 시간 */
    @Column(name = "arrival_flight_date")
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime arrivalFlightDate;

    /* 마지막 다이브 날짜 */
    @Column(name = "last_dive_date")
    @JdbcTypeCode(SqlTypes.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastDiveDate;

    /* 약관 동의 여부 */
    @Column(name = "agree_terms", nullable = false)
    @JdbcTypeCode(SqlTypes.BOOLEAN)
    private Boolean agreeTerms;

    /* 비고 */
    @Column(name = "note", length = 1000)
    private String note;

    /* 여행 숙소 ID */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_lodging_id", nullable = false, insertable = true, updatable = true)
    private TripLodging tripLodging;

    /* 다이버 ID */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diver_id", nullable = false, insertable = true, updatable = true)
    private Diver diver;

    /* 여행 예약 상태 이력 */
    @OneToMany(mappedBy = "tripReservation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<TripReservationStatusHistory> statusHistorys = new ArrayList<>();

    /* 결제 이력 */
    @OneToMany(mappedBy = "tripReservation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Payment> payments = new ArrayList<>();

    public void addStatusHistorys(TripReservationStatusHistory tripReservationStatusHistory) {
        this.statusHistorys.add(tripReservationStatusHistory);
    }

}
