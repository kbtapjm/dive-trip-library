package io.divetrip.library.domain.repository.custom;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.divetrip.library.domain.entity.QDiver;
import io.divetrip.library.domain.entity.QDiverLoginHistory;
import io.divetrip.library.domain.repository.dto.request.DiverLoginHistoryQueryRequest;
import io.divetrip.library.domain.repository.dto.response.DiverLoginHistoryQueryResponse;
import io.divetrip.library.domain.repository.dto.response.QDiverLoginHistoryQueryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class DiverLoginHistoryRepositoryImpl implements DiverLoginHistoryRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    final QDiver diver = QDiver.diver;

    final QDiverLoginHistory diverLoginHistory = QDiverLoginHistory.diverLoginHistory;

    @Override
    public List<DiverLoginHistoryQueryResponse> findLoginHistoryCntBy(DiverLoginHistoryQueryRequest diverLoginHistoryQueryRequest) {
        return queryFactory
                .select(new QDiverLoginHistoryQueryResponse(
                        diver.diverId,
                        diver.email,
                        diverLoginHistory.count().intValue(),
                        diverLoginHistory.createdAt.max()
                ))
                .from(diverLoginHistory)
                .join(diver).on(diverLoginHistory.diver.eq(diver))
                .groupBy(diverLoginHistory.diver.diverId, diver.email)
                .fetch();
    }
}
