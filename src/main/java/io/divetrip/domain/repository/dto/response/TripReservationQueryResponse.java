package io.divetrip.domain.repository.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import io.divetrip.domain.entity.enumeration.ReservationStatus;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class TripReservationQueryResponse {
    /* 여행 예약 ID */
    private UUID tripReservationId;

    /* 예약 상태 */
    private ReservationStatus reservationStatus;

    /* 결제 여부 */
    private Boolean paid;

    /* 출발 편명 */
    private String departureFlightNumbers;

    /* 출발 시간 */
    private LocalDateTime departureFlightDate;

    /* 도착 편명 */
    private String arrivalFlightNumbers;

    /* 도착 시간 */
    private LocalDateTime arrivalFlightDate;

    /* 마지막 다이브 날짜 */
    private LocalDate lastDiveDate;

    /* 약관 동의 여부 */
    private Boolean agreeTerms;

    /* 비고 */
    private String note;

    /* 등록자 */
    private String createdBy;

    /* 등록일 */
    private LocalDateTime createdAt;

    /* 수정자 */
    private String updatedBy;

    /* 수정일 */
    private LocalDateTime updatedAt;

    @QueryProjection
    public TripReservationQueryResponse(UUID tripReservationId, ReservationStatus reservationStatus, Boolean paid, String departureFlightNumbers, LocalDateTime departureFlightDate, String arrivalFlightNumbers, LocalDateTime arrivalFlightDate, LocalDate lastDiveDate, Boolean agreeTerms, String note, String createdBy, LocalDateTime createdAt, String updatedBy, LocalDateTime updatedAt) {
        this.tripReservationId = tripReservationId;
        this.reservationStatus = reservationStatus;
        this.paid = paid;
        this.departureFlightNumbers = departureFlightNumbers;
        this.departureFlightDate = departureFlightDate;
        this.arrivalFlightNumbers = arrivalFlightNumbers;
        this.arrivalFlightDate = arrivalFlightDate;
        this.lastDiveDate = lastDiveDate;
        this.agreeTerms = agreeTerms;
        this.note = note;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
    }
}
