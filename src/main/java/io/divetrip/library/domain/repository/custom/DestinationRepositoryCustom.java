package io.divetrip.library.domain.repository.custom;

import io.divetrip.library.domain.repository.dto.request.DestinationQueryRequest;
import io.divetrip.library.domain.repository.dto.response.DestinationQueryResponse;

import java.util.List;

public interface DestinationRepositoryCustom {

    List<DestinationQueryResponse> findAllBy(DestinationQueryRequest destinationQueryRequest);
}
