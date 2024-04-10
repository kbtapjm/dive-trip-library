package io.divetrip.domain.repository;

import io.divetrip.domain.entity.TripLodging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TripLodgingRepository extends JpaRepository<TripLodging, UUID> {

}
