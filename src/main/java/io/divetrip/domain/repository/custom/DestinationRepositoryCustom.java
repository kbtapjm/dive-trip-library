package io.divetrip.domain.repository.custom;

import io.divetrip.domain.repository.dto.request.DestinationQueryRequest;
import io.divetrip.domain.repository.dto.response.DestinationQueryResponse;

import java.util.List;

public interface DestinationRepositoryCustom {

    List<DestinationQueryResponse> findAllBy(DestinationQueryRequest destinationQueryRequest);
}
