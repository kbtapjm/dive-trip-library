package io.divetrip.library.domain.repository;

import io.divetrip.library.domain.entity.TripReservationStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TripReservationStatusHistoryRepository extends JpaRepository<TripReservationStatusHistory, UUID> {

}
