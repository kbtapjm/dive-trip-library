package io.divetrip.library.common.domain;

import io.divetrip.library.domain.entity.Diver;
import io.divetrip.library.domain.entity.enumeration.Gender;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class DiverSpecification implements Specification<Diver> {
    @Serial
    private static final long serialVersionUID = 6251533342268711516L;

    private final String name;
    private final String gender;

    @Override
    public Predicate toPredicate(Root<Diver> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.isNotEmpty(name)) {
            predicates.add(criteriaBuilder.or(criteriaBuilder.like(root.get("familyName"), "%" + name + "%"),
                    criteriaBuilder.like(root.get("givenName"), "%" + name + "%")
                    )
            );
        }
        if (StringUtils.isNotEmpty(gender)) {
            predicates.add(criteriaBuilder.equal(root.get("gender"), Gender.valueOf(gender)));
        }

        final Predicate[] predicateArray = new Predicate[predicates.size()];

        return query
                .where(criteriaBuilder.and(predicates.toArray(predicateArray)))
                .distinct(true)
                .getRestriction();
    }

    private static Specification<Diver> byFamilyName(String familyName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("familyName"), familyName);
    }

    private static Specification<Diver> byGivenName(String givenName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("givenName"), givenName);
    }

}
