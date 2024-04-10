package io.divetrip.domain.repository;

import io.divetrip.domain.entity.TripStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TripStatusHistoryRepository extends JpaRepository<TripStatusHistory, UUID> {
}
