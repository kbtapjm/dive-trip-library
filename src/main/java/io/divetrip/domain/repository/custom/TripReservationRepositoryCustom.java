package io.divetrip.domain.repository.custom;

import io.divetrip.domain.repository.dto.request.TripReservationQueryRequest;
import io.divetrip.domain.repository.dto.response.TripReservationQueryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TripReservationRepositoryCustom {

    Page<TripReservationQueryResponse> findAllBy(Pageable pageable, TripReservationQueryRequest tripReservationQueryRequest);
}
