package io.divetrip.domain.repository.custom;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.divetrip.domain.entity.QTrip;
import io.divetrip.domain.repository.dto.request.TripQueryRequest;
import io.divetrip.domain.repository.dto.response.QTripQueryResponse;
import io.divetrip.domain.repository.dto.response.TripQueryResponse;
import io.divetrip.util.QueryDslUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class TripRepositoryImpl implements TripRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    private final QTrip trip = QTrip.trip;

    @Override
    public Page<TripQueryResponse> findAllBy(Pageable pageable, TripQueryRequest tripQueryRequest) {
        List<TripQueryResponse> results = queryFactory
                .select(new QTripQueryResponse(
                        trip.tripId,
                        trip.tripStatus,
                        trip.departureTime,
                        trip.returnTime,
                        trip.startPort,
                        trip.endPort,
                        trip.durations,
                        trip.totalDives,
                        trip.createdBy,
                        trip.createdAt,
                        trip.updatedBy,
                        trip.updatedAt
                ))
                .from(trip)
                .where()
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(QueryDslUtils.createOrderSpecifier(pageable.getSort()))
                .fetch();

        JPAQuery<Long> count = queryFactory
                .select(trip.count())
                .from(trip);

        return PageableExecutionUtils.getPage(results, pageable, count::fetchCount);
    }

}
