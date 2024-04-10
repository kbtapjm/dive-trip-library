package io.divetrip.domain.repository.custom;

import io.divetrip.domain.repository.dto.request.VesselQueryRequest;
import io.divetrip.domain.repository.dto.response.VesselQueryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VesselRepositoryCustom {

    Page<VesselQueryResponse> findAllBy(Pageable pageable, VesselQueryRequest vesselQueryRequest);

}
