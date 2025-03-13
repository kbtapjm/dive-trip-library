package io.divetrip.library.domain.repository.custom;


import io.divetrip.library.domain.repository.dto.request.VesselQueryRequest;
import io.divetrip.library.domain.repository.dto.response.VesselQueryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VesselRepositoryCustom {

    Page<VesselQueryResponse> findAllBy(Pageable pageable, VesselQueryRequest vesselQueryRequest);

}
