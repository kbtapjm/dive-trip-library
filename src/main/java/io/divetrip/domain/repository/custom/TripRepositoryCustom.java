package io.divetrip.domain.repository.custom;

import io.divetrip.domain.repository.dto.request.TripQueryRequest;
import io.divetrip.domain.repository.dto.response.TripQueryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TripRepositoryCustom {

    Page<TripQueryResponse> findAllBy(Pageable pageable, TripQueryRequest tripQueryRequest);

}
