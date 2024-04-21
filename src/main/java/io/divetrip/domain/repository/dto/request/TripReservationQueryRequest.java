package io.divetrip.domain.repository.dto.request;

import io.divetrip.domain.entity.enumeration.ReservationStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class TripReservationQueryRequest {
    /* 예약 상태 */
    private ReservationStatus reservationStatus;
}
