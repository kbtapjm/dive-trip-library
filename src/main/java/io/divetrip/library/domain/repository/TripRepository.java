package io.divetrip.library.domain.repository;

import io.divetrip.library.domain.entity.Trip;
import io.divetrip.library.domain.repository.custom.TripRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TripRepository extends JpaRepository<Trip, UUID>, TripRepositoryCustom {

}
