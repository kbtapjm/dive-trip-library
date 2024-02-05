package io.divetrip.domain.repository.custom;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.divetrip.domain.entity.QVessel;
import io.divetrip.domain.repository.dto.request.VesselQueryRequest;
import io.divetrip.domain.repository.dto.response.VesselQueryResponse;
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
                .select(
                        Projections.fields(
                                VesselQueryResponse.class,
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
                                vessel.dieselTank,
                                vessel.range,
                                vessel.used,
                                vessel.createdBy,
                                vessel.createdAt,
                                vessel.updatedBy,
                                vessel.updatedAt
                        )
                )
                .from(vessel)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(this.createOrderSpecifier(pageable.getSort()))
                .fetch();

        JPAQuery<Long> count = queryFactory
                .select(vessel.count())
                .from(vessel);

        return PageableExecutionUtils.getPage(results, pageable, count::fetchCount);
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
