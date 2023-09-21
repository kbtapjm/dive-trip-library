package io.divetrip.domain.repository;

import io.divetrip.domain.entity.Diver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DiverRepository extends JpaRepository<Diver, UUID> {
}