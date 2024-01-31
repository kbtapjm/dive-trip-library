package io.divetrip.domain.repository;

import io.divetrip.domain.entity.Vessel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VesselRepository extends JpaRepository<Vessel, UUID>, QuerydslPredicateExecutor<Vessel> {

}
