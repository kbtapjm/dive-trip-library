package io.divetrip.library.domain.repository;

import io.divetrip.library.domain.entity.TripLodging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TripLodgingRepository extends JpaRepository<TripLodging, UUID> {

}
