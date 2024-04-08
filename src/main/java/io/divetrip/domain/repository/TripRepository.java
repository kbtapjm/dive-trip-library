package io.divetrip.domain.repository;

import io.divetrip.domain.entity.Trip;
import io.divetrip.domain.repository.custom.TripRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TripRepository extends JpaRepository<Trip, UUID>, TripRepositoryCustom {

}
