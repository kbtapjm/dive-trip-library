package io.divetrip.library.domain.repository;

import io.divetrip.library.domain.entity.Destination;
import io.divetrip.library.domain.repository.custom.DestinationRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, UUID>, DestinationRepositoryCustom {
}
