package io.divetrip.domain.repository.custom;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.divetrip.domain.entity.QVessel;
import io.divetrip.domain.entity.enumeration.VesselStatus;
import io.divetrip.domain.repository.dto.request.VesselQueryRequest;
import io.divetrip.domain.repository.dto.response.QVesselQueryResponse;
import io.divetrip.domain.repository.dto.response.VesselQueryResponse;
import io.divetrip.util.QueryDslUtils;
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
public class VesselRepositoryImpl implements VesselRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final QVessel vessel = QVessel.vessel;

    @Override
    public Page<VesselQueryResponse> findAllBy(Pageable pageable, VesselQueryRequest vesselQueryRequest) {
        List<VesselQueryResponse> results = queryFactory
                .select(new QVesselQueryResponse(
                        vessel.vesselId,
                        vessel.vesselName,
                        vessel.vesselStatus,
                        vessel.totalGuests,
                        vessel.crew,
                        vessel.numberCabins,
                        vessel.length,
                        vessel.width,
                        vessel.hull,
                        vessel.crusingSpeed,
                        vessel.engine,
                        vessel.generator,
                        vessel.compressor,
                        vessel.nitrox,
                        vessel.dinghy,
                        vessel.waterMakers,
                        vessel.freshWaterTank,
                        vessel.dieselTank,
                        vessel.range,
                        vessel.used,
                        vessel.createdBy,
                        vessel.createdAt,
                        vessel.updatedBy,
                        vessel.updatedAt
                ))
                .from(vessel)
                .where(
                        this.vesselNameContains(vesselQueryRequest.getVesselName()),
                        this.vesselStatusEq(vesselQueryRequest.getVesselStatus()),
                        this.usedEq(vesselQueryRequest.getUsed())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(this.createOrderSpecifier(pageable.getSort()))
                .fetch();

        JPAQuery<Long> count = queryFactory
                .select(vessel.count())
                .from(vessel);

        return PageableExecutionUtils.getPage(results, pageable, count::fetchCount);
    }

    private BooleanBuilder vesselNameContains(String vesselName) {
        return QueryDslUtils.nullSafeBuilder(() -> vessel.vesselName.contains(vesselName));
    }

    private BooleanBuilder vesselStatusEq(VesselStatus vesselStatus) {
        return QueryDslUtils.nullSafeBuilder(() -> vessel.vesselStatus.eq(vesselStatus));
    }

    private BooleanBuilder usedEq(Boolean used) {
        return QueryDslUtils.nullSafeBuilder(() -> vessel.used.eq(used));
    }

    private OrderSpecifier<?> createOrderSpecifier(Sort sort) {
        OrderSpecifier<?> orderSpecifier = null;

        for (Sort.Order order : sort) {
            PathBuilder<Object> path = new PathBuilder<Object>(Object.class, order.getProperty());
            orderSpecifier =  new OrderSpecifier(Order.valueOf(order.getDirection().name()), path);
        }

        return orderSpecifier;
    }

}
