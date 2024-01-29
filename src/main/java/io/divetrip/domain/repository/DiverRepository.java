package io.divetrip.domain.repository;

import io.divetrip.domain.entity.Diver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DiverRepository extends JpaRepository<Diver, UUID>, QuerydslPredicateExecutor<Diver>, JpaSpecificationExecutor<Diver> {

    boolean existsByEmail(String email);

    Page<Diver> findAll(Specification<Diver> spec, Pageable pageable);

}