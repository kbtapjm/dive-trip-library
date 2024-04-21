package io.divetrip.domain.repository.custom;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.divetrip.domain.entity.QTripReservation;
import io.divetrip.domain.entity.enumeration.ReservationStatus;
import io.divetrip.domain.repository.dto.request.TripReservationQueryRequest;
import io.divetrip.domain.repository.dto.response.QTripReservationQueryResponse;
import io.divetrip.domain.repository.dto.response.TripReservationQueryResponse;
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
public class TripReservationRepositoryImpl implements TripReservationRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    private final QTripReservation tripReservation = QTripReservation.tripReservation;

    @Override
    public Page<TripReservationQueryResponse> findAllBy(Pageable pageable, TripReservationQueryRequest tripReservationQueryRequest) {
        List<TripReservationQueryResponse> results = queryFactory
                .select(new QTripReservationQueryResponse(
                        tripReservation.tripReservationId,
                        tripReservation.reservationStatus,
                        tripReservation.paid,
                        tripReservation.departureFlightNumbers,
                        tripReservation.departureFlightDate,
                        tripReservation.arrivalFlightNumbers,
                        tripReservation.arrivalFlightDate,
                        tripReservation.lastDiveDate,
                        tripReservation.agreeTerms,
                        tripReservation.note,
                        tripReservation.createdBy,
                        tripReservation.createdAt,
                        tripReservation.updatedBy,
                        tripReservation.updatedAt
                ))
                .from(tripReservation)
                .where(
                        this.reservationStatusEq(tripReservationQueryRequest.getReservationStatus())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(QueryDslUtils.createOrderSpecifier(pageable.getSort()))
                .fetch();

        JPAQuery<Long> count = queryFactory
                .select(tripReservation.count())
                .from(tripReservation)
                .where(
                        this.reservationStatusEq(tripReservationQueryRequest.getReservationStatus())
                );

        return PageableExecutionUtils.getPage(results, pageable, count::fetchCount);
    }

    private BooleanBuilder reservationStatusEq(ReservationStatus reservationStatus) {
        return QueryDslUtils.nullSafeBuilder(() -> tripReservation.reservationStatus.eq(reservationStatus));
    }

}
