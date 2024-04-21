package io.divetrip.domain.repository;

import io.divetrip.domain.entity.TripReservation;
import io.divetrip.domain.repository.custom.TripReservationRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TripReservationRepository extends JpaRepository<TripReservation, UUID>, TripReservationRepositoryCustom {

}
