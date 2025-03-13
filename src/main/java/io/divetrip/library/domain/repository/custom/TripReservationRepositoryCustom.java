package io.divetrip.library.domain.repository.custom;


import io.divetrip.library.domain.repository.dto.request.TripReservationQueryRequest;
import io.divetrip.library.domain.repository.dto.response.TripReservationQueryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TripReservationRepositoryCustom {

    Page<TripReservationQueryResponse> findAllBy(Pageable pageable, TripReservationQueryRequest tripReservationQueryRequest);
}
