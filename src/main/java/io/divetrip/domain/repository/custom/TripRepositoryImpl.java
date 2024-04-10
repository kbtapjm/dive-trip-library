package io.divetrip.domain.repository.custom;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.divetrip.domain.entity.QCountry;
import io.divetrip.domain.entity.QDestination;
import io.divetrip.domain.entity.QTrip;
import io.divetrip.domain.entity.QVessel;
import io.divetrip.domain.entity.enumeration.TripStatus;
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
    private final QDestination destination = QDestination.destination;
    private final QCountry country = QCountry.country;
    private final QVessel vessel = QVessel.vessel;

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
                        country.countryName,
                        destination.area,
                        vessel.vesselName,
                        vessel.vesselStatus,
                        trip.createdBy,
                        trip.createdAt,
                        trip.updatedBy,
                        trip.updatedAt
                ))
                .from(trip)
                    .join(destination).on(trip.destination.eq(destination))
                    .join(vessel).on(trip.vessel.eq(vessel))
                    .join(destination).on(destination.country.eq(country))
                .where(
                        this.tripStatusEq(tripQueryRequest.getTripStatus()),
                        this.areaContains(tripQueryRequest.getArea())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(QueryDslUtils.createOrderSpecifier(pageable.getSort()))
                .fetch();

        JPAQuery<Long> count = queryFactory
                .select(trip.count())
                .from(trip)
                .join(destination).on(trip.destination.eq(destination))
                .join(vessel).on(trip.vessel.eq(vessel))
                .join(destination).on(destination.country.eq(country))
                .where(
                        this.tripStatusEq(tripQueryRequest.getTripStatus()),
                        this.areaContains(tripQueryRequest.getArea())
                );

        return PageableExecutionUtils.getPage(results, pageable, count::fetchCount);
    }

    private BooleanBuilder tripStatusEq(TripStatus tripStatus) {
        return QueryDslUtils.nullSafeBuilder(() -> trip.tripStatus.eq(tripStatus));
    }

    private BooleanBuilder areaContains(String area) {
        return QueryDslUtils.nullSafeBuilder(() -> destination.area.contains(area));
    }

}
