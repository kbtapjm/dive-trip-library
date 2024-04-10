package io.divetrip.domain.repository;

import io.divetrip.domain.entity.Destination;
import io.divetrip.domain.repository.custom.DestinationRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, UUID>, DestinationRepositoryCustom {
}
