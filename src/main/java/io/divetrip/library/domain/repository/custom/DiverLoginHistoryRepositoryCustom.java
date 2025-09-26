package io.divetrip.library.domain.repository.custom;

import io.divetrip.library.domain.repository.dto.request.DiverLoginHistoryQueryRequest;
import io.divetrip.library.domain.repository.dto.response.DiverLoginHistoryQueryResponse;

import java.util.List;

public interface DiverLoginHistoryRepositoryCustom {

    List<DiverLoginHistoryQueryResponse> findLoginHistoryCntBy(DiverLoginHistoryQueryRequest diverLoginHistoryQueryRequest);

}
