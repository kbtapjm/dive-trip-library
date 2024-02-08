package io.divetrip.domain.repository;

import io.divetrip.domain.entity.Vessel;
import io.divetrip.domain.entity.VesselCabin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VesselCabinRepository extends JpaRepository<VesselCabin, UUID> {

    boolean existsByVesselAndCabinName(final Vessel Vessel, final String cabinName);

    Optional<VesselCabin> findByVesselAndVesselCabinId(final Vessel Vessel, final UUID vesselCabinId);

}
