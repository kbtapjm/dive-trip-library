package io.divetrip.library.domain.repository.custom;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.divetrip.library.domain.entity.QDiver;
import io.divetrip.library.domain.entity.QTripLodging;
import io.divetrip.library.domain.entity.QTripReservation;
import io.divetrip.library.domain.entity.enumeration.ReservationStatus;
import io.divetrip.library.domain.repository.dto.request.TripReservationQueryRequest;
import io.divetrip.library.domain.repository.dto.response.QTripReservationQueryResponse;
import io.divetrip.library.domain.repository.dto.response.TripReservationQueryResponse;
import io.divetrip.library.util.QueryDslUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class TripReservationRepositoryImpl implements TripReservationRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    private final QTripReservation tripReservation = QTripReservation.tripReservation;
    private final QDiver diver = QDiver.diver;
    private final QTripLodging tripLodging = QTripLodging.tripLodging;

    @Override
    public Page<TripReservationQueryResponse> findAllBy(Pageable pageable, TripReservationQueryRequest tripReservationQueryRequest) {
        List<TripReservationQueryResponse> results = queryFactory
                .select(new QTripReservationQueryResponse(
                        tripReservation.tripReservationId,
                        tripLodging.tripLodgingId,
                        diver.diverId,
                        diver.familyName,
                        diver.givenName,
                        tripReservation.reservationStatus,
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
                .join(diver).on(tripReservation.diver.diverId.eq(diver.diverId))
                .join(tripLodging).on(tripReservation.tripLodging.tripLodgingId.eq(tripLodging.tripLodgingId))
                .where(
                        this.reservationStatusEq(tripReservationQueryRequest.getReservationStatus())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(this.getOrderSpecifier(pageable.getSort()))
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

    private OrderSpecifier<?> getOrderSpecifier(Sort sort) {
        OrderSpecifier<?> orderSpecifier = null;

        for (Sort.Order order : sort) {
            switch (order.getProperty()) {
                case "createdAt":
                    orderSpecifier = new OrderSpecifier<>(Order.valueOf(order.getDirection().name()),tripReservation.createdAt);
                    break;
                default:
                    orderSpecifier = new OrderSpecifier<>(Order.DESC, tripReservation.createdAt);
                    break;
            }
        }

        return orderSpecifier;
    }

}
