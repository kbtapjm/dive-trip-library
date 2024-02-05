package io.divetrip.domain.repository;

import io.divetrip.domain.entity.Vessel;
import io.divetrip.domain.repository.custom.VesselRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VesselRepository extends JpaRepository<Vessel, UUID>, VesselRepositoryCustom {

    boolean existsByVesselName(final String vesselName);

}
