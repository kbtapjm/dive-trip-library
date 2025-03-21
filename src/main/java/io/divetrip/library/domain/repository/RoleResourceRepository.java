package io.divetrip.library.domain.repository;

import io.divetrip.library.domain.entity.RoleResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleResourceRepository extends JpaRepository<RoleResource, UUID> {

}
