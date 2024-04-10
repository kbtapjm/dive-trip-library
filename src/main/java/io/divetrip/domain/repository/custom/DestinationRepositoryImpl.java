package io.divetrip.domain.repository.custom;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.divetrip.domain.entity.QCountry;
import io.divetrip.domain.entity.QDestination;
import io.divetrip.domain.entity.enumeration.Continent;
import io.divetrip.domain.repository.dto.request.DestinationQueryRequest;
import io.divetrip.domain.repository.dto.response.DestinationQueryResponse;
import io.divetrip.util.QueryDslUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class DestinationRepositoryImpl implements DestinationRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    final QDestination destination = QDestination.destination;
    final QCountry country = QCountry.country;

    @Override
    public List<DestinationQueryResponse> findAllBy(DestinationQueryRequest destinationQueryRequest) {
        return queryFactory
                .select(
                        Projections.fields(
                                DestinationQueryResponse.class,
                                destination.destinationId,
                                destination.continent,
                                destination.area,
                                destination.description,
                                destination.createdBy,
                                destination.createdAt,
                                destination.updatedBy,
                                destination.updatedAt,
                                country.countryId,
                                country.iso,
                                country.countryName
                ))
                .from(destination).join(country).on(destination.country.eq(country))
                .where(
                        this.continentEq(destinationQueryRequest.getContinent()),
                        this.areaContains(destinationQueryRequest.getArea()),
                        this.countryIdEq(destinationQueryRequest.getCountryId())
                )
                .orderBy(destination.area.asc())
                .fetch();
    }

    private BooleanBuilder continentEq(Continent continent) {
        return QueryDslUtils.nullSafeBuilder(() -> destination.continent.eq(continent));
    }

    private BooleanBuilder areaContains(String area) {
        return QueryDslUtils.nullSafeBuilder(() -> destination.area.contains(area));
    }

    private BooleanBuilder countryIdEq(Long countryId) {
        return QueryDslUtils.nullSafeBuilder(() -> country.countryId.eq(countryId));
    }

}
