package io.divetrip.library.domain.repository;

import io.divetrip.library.domain.entity.DiverLoginHistory;
import io.divetrip.library.domain.repository.custom.DiverLoginHistoryRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DiverLoginHistoryRepository extends JpaRepository<DiverLoginHistory, UUID>, DiverLoginHistoryRepositoryCustom {
}
