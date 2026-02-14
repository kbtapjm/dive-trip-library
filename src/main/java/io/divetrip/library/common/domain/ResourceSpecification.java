package io.divetrip.library.common.domain;

import io.divetrip.library.domain.entity.Resource;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
public class ResourceSpecification implements Specification<Resource> {
    /* 그룹 ID */
    private final UUID groupId;

    /* 리소스 명 */
    private final String resourceName;

    /* 사용 여부 */
    private final Boolean used;

    @Override
    public Predicate toPredicate(Root<Resource> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (Objects.isNull(groupId)) {
            predicates.add(criteriaBuilder.isNull(root.get("groupId")));
        } else {
            predicates.add(criteriaBuilder.equal(root.get("groupId"), groupId));
        }

        if (StringUtils.isNotEmpty(resourceName)) {
            predicates.add(criteriaBuilder.like(root.get("resourceName"), "%" + resourceName + "%"));
        }
        if (!Objects.isNull(used)) {
            predicates.add(criteriaBuilder.equal(root.get("used"), used));
        }

        final Predicate[] predicateArray = new Predicate[predicates.size()];

        return query
                .where(criteriaBuilder.and(predicates.toArray(predicateArray)))
                .getRestriction();
    }

}
