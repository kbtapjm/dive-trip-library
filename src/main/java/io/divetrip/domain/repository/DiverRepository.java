package io.divetrip.domain.repository;

import io.divetrip.domain.entity.Diver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DiverRepository extends JpaRepository<Diver, Long>, QuerydslPredicateExecutor<Diver> {

    boolean existsByEmail(String email);

}