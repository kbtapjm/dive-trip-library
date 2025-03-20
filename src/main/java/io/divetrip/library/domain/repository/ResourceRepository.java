package io.divetrip.library.domain.repository;

import io.divetrip.library.domain.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, UUID>, QuerydslPredicateExecutor<Resource>, JpaSpecificationExecutor<Resource> {

    boolean existsByResourceUrl(final String resourceUrl);

    List<Resource> findByGroupId(final UUID groupId);

}
