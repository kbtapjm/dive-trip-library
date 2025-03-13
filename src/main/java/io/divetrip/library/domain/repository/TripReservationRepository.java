package io.divetrip.library.domain.repository;

import io.divetrip.library.domain.entity.Diver;
import io.divetrip.library.domain.entity.TripLodging;
import io.divetrip.library.domain.entity.TripReservation;
import io.divetrip.library.domain.repository.custom.TripReservationRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TripReservationRepository extends JpaRepository<TripReservation, UUID>, TripReservationRepositoryCustom {

    boolean existsByDiverAndTripLodging(final Diver diver, final TripLodging tripLodging);

}
